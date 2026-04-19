package net.mcreator.main.procedures;

import net.minecraft.world.entity.Entity;

public class StartFlyingOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("isFlying", true);
	}
}