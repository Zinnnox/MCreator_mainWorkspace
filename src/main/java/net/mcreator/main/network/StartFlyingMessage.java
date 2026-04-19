package net.mcreator.main.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.main.procedures.StartFlyingOnKeyReleasedProcedure;
import net.mcreator.main.procedures.StartFlyingOnKeyPressedProcedure;
import net.mcreator.main.MainMod;

@EventBusSubscriber
public record StartFlyingMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<StartFlyingMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MainMod.MODID, "key_start_flying"));
	public static final StreamCodec<RegistryFriendlyByteBuf, StartFlyingMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, StartFlyingMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new StartFlyingMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<StartFlyingMessage> type() {
		return TYPE;
	}

	public static void handleData(final StartFlyingMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (type == 0) {

			StartFlyingOnKeyPressedProcedure.execute(entity);
		}
		if (type == 1) {

			StartFlyingOnKeyReleasedProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MainMod.addNetworkMessage(StartFlyingMessage.TYPE, StartFlyingMessage.STREAM_CODEC, StartFlyingMessage::handleData);
	}
}