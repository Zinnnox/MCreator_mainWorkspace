/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.main.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.main.block.SignalBlockBlock;
import net.mcreator.main.block.RemoteBlockOnBlock;
import net.mcreator.main.block.RemoteBlockOffBlock;
import net.mcreator.main.block.PieTreeSaplingBlock;
import net.mcreator.main.MainMod;

import java.util.function.Function;

public class MainModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MainMod.MODID);
	public static final DeferredBlock<Block> PIE_TREE_SAPLING;
	public static final DeferredBlock<Block> SIGNAL_BLOCK;
	public static final DeferredBlock<Block> REMOTE_BLOCK_OFF;
	public static final DeferredBlock<Block> REMOTE_BLOCK_ON;
	static {
		PIE_TREE_SAPLING = register("pie_tree_sapling", PieTreeSaplingBlock::new);
		SIGNAL_BLOCK = register("signal_block", SignalBlockBlock::new);
		REMOTE_BLOCK_OFF = register("remote_block_off", RemoteBlockOffBlock::new);
		REMOTE_BLOCK_ON = register("remote_block_on", RemoteBlockOnBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}