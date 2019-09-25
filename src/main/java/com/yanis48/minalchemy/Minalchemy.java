package com.yanis48.minalchemy;

import com.yanis48.minalchemy.container.AlchemyTableContainer;
import com.yanis48.minalchemy.init.LootTableEntries;
import com.yanis48.minalchemy.init.MinalchemyBlocks;
import com.yanis48.minalchemy.init.MinalchemyItems;
import com.yanis48.minalchemy.init.MinalchemyRecipes;
import com.yanis48.minalchemy.init.MinalchemyStats;
import com.yanis48.minalchemy.init.MinalchemyTags;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Minalchemy implements ModInitializer {
	
	public static final String MOD_ID = "minalchemy";
	
	public static final ItemGroup MINALCHEMY = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "minalchemy"), () -> new ItemStack(MinalchemyItems.ALCHEMY_TABLE));
	
	public static final Identifier ALCHEMY_TABLE_CONTAINER = new Identifier(MOD_ID, "alchemy_table");
	
	@Override
	public void onInitialize() {
		new MinalchemyBlocks();
		new MinalchemyItems();
		new MinalchemyRecipes();
		new MinalchemyStats();
		new MinalchemyTags();
		
		LootTableEntries.addToLootTables();
		
		ContainerProviderRegistry.INSTANCE.registerFactory(ALCHEMY_TABLE_CONTAINER, (syncId, identifier, player, buf) -> {
			return new AlchemyTableContainer(syncId, player);
		});
		
		FuelRegistry.INSTANCE.add(MinalchemyItems.ALCHEMY_TABLE, 300);
	}
}
