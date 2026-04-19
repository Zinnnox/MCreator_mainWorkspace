/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.main.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.main.block.PieTreeSaplingBlock;
import net.mcreator.main.MainMod;

import java.util.function.Function;

public class MainModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MainMod.MODID);
	public static final DeferredBlock<Block> PIE_TREE_SAPLING;
	static {
		PIE_TREE_SAPLING = register("pie_tree_sapling", PieTreeSaplingBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}