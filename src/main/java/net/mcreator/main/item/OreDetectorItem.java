package net.mcreator.main.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.main.procedures.OreDetectorItemInHandTickProcedure;

import javax.annotation.Nullable;

public class OreDetectorItem extends Item {
	public OreDetectorItem(Item.Properties properties) {
		super(properties.durability(100).repairable(TagKey.create(Registries.ITEM, ResourceLocation.parse("main:ore_detector_repair_items"))));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		if (equipmentSlot == EquipmentSlot.MAINHAND)
			OreDetectorItemInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
	}
}