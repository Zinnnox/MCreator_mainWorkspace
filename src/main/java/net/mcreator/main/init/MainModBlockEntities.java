/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.main.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.main.block.entity.SignalBlockBlockEntity;
import net.mcreator.main.block.entity.RemoteBlockOnBlockEntity;
import net.mcreator.main.block.entity.RemoteBlockOffBlockEntity;
import net.mcreator.main.MainMod;

@EventBusSubscriber
public class MainModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MainMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SignalBlockBlockEntity>> SIGNAL_BLOCK = register("signal_block", MainModBlocks.SIGNAL_BLOCK, SignalBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RemoteBlockOffBlockEntity>> REMOTE_BLOCK_OFF = register("remote_block_off", MainModBlocks.REMOTE_BLOCK_OFF, RemoteBlockOffBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RemoteBlockOnBlockEntity>> REMOTE_BLOCK_ON = register("remote_block_on", MainModBlocks.REMOTE_BLOCK_ON, RemoteBlockOnBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SIGNAL_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, REMOTE_BLOCK_OFF.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, REMOTE_BLOCK_ON.get(), SidedInvWrapper::new);
	}
}