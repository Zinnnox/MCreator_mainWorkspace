/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.main.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.main.network.StartFlyingMessage;

@EventBusSubscriber(Dist.CLIENT)
public class MainModKeyMappings {
	public static final KeyMapping START_FLYING = new KeyMapping("key.main.start_flying", GLFW.GLFW_KEY_M, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new StartFlyingMessage(0, 0));
				StartFlyingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				START_FLYING_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - START_FLYING_LASTPRESS);
				ClientPacketDistributor.sendToServer(new StartFlyingMessage(1, dt));
				StartFlyingMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long START_FLYING_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(START_FLYING);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				START_FLYING.consumeClick();
			}
		}
	}
}