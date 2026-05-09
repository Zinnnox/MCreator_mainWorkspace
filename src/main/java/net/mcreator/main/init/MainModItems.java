/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.main.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.main.item.RedstoneControlRemoteItem;
import net.mcreator.main.item.OreDetectorItem;
import net.mcreator.main.item.MiningHammerItem;
import net.mcreator.main.MainMod;

import java.util.function.Function;

public class MainModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MainMod.MODID);
	public static final DeferredItem<Item> PIE_TREE_SAPLING;
	public static final DeferredItem<Item> REDSTONE_CONTROL_REMOTE;
	public static final DeferredItem<Item> ORE_DETECTOR;
	public static final DeferredItem<Item> MINING_HAMMER;
	public static final DeferredItem<Item> SIGNAL_BLOCK;
	public static final DeferredItem<Item> REMOTE_BLOCK_OFF;
	public static final DeferredItem<Item> REMOTE_BLOCK_ON;
	static {
		PIE_TREE_SAPLING = block(MainModBlocks.PIE_TREE_SAPLING);
		REDSTONE_CONTROL_REMOTE = register("redstone_control_remote", RedstoneControlRemoteItem::new);
		ORE_DETECTOR = register("ore_detector", OreDetectorItem::new);
		MINING_HAMMER = register("mining_hammer", MiningHammerItem::new);
		SIGNAL_BLOCK = block(MainModBlocks.SIGNAL_BLOCK);
		REMOTE_BLOCK_OFF = block(MainModBlocks.REMOTE_BLOCK_OFF);
		REMOTE_BLOCK_ON = block(MainModBlocks.REMOTE_BLOCK_ON);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}
}