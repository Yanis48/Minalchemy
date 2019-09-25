package com.yanis48.minalchemy.block;

import com.yanis48.minalchemy.Minalchemy;
import com.yanis48.minalchemy.init.MinalchemyStats;

import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AlchemyTable extends Block {
	
	public AlchemyTable(Block.Settings settings) {
		super(settings);
	}
	
	public boolean activate(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
		if (!world.isClient) {
			ContainerProviderRegistry.INSTANCE.openContainer(Minalchemy.ALCHEMY_TABLE_CONTAINER, player, buf -> buf.writeBlockPos(pos));
			player.incrementStat(MinalchemyStats.INTERACT_WITH_ALCHEMY_TABLE);
		}
		return true;
	}
}
