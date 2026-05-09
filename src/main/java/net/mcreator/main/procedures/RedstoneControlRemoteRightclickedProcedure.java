package net.mcreator.main.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.main.init.MainModBlocks;

public class RedstoneControlRemoteRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MainModBlocks.REMOTE_BLOCK_OFF.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MainModBlocks.REMOTE_BLOCK_ON.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("BlockPosX", x);
					_blockEntity.getPersistentData().putDouble("BlockPosY", y);
					_blockEntity.getPersistentData().putDouble("BlockPosZ", z);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}