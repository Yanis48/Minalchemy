package com.yanis48.minalchemy.init;

import com.yanis48.minalchemy.Minalchemy;
import com.yanis48.minalchemy.block.AlchemyTable;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MinalchemyBlocks {
	
	public static final Block ALCHEMY_TABLE = register("alchemy_table", new AlchemyTable(FabricBlockSettings.of(Material.WOOD).strength(2.5F, 2.5F).sounds(BlockSoundGroup.WOOD).build()));
	
	private static Block register(String name, Block block) {
		return Registry.register(Registry.BLOCK, new Identifier(Minalchemy.MOD_ID, name), block);
	}
}
