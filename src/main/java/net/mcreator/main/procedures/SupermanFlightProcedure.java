package net.mcreator.main.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SupermanFlightProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		boolean isFlying = false;
		isFlying = entity.getPersistentData().getBooleanOr("isFlying", false);
		if (isFlying) {
			if (entity instanceof Player _player) {
				_player.startFallFlying();
			}
		} else {
			if (entity instanceof Player _player) {
				_player.stopFallFlying();
			}
		}
	}
}