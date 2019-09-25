package com.yanis48.minalchemy.init;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.util.Identifier;
import net.minecraft.world.loot.ConstantLootTableRange;
import net.minecraft.world.loot.UniformLootTableRange;
import net.minecraft.world.loot.entry.ItemEntry;
import net.minecraft.world.loot.function.SetCountLootFunction;

public class LootTableEntries {
	private static final Identifier PHANTOM = new Identifier("minecraft", "entities/phantom");
	private static final Identifier ZOMBIE = new Identifier("minecraft", "entities/zombie");
	private static final Identifier HUSK = new Identifier("minecraft", "entities/husk");
	private static final Identifier DROWNED = new Identifier("minecraft", "entities/drowned");
	
	public static void addToLootTables() {
		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
			if (PHANTOM.equals(id)) {
				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
						.withRolls(ConstantLootTableRange.create(1))
						.withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(1, 3)))
						.withEntry(ItemEntry.builder(MinalchemyItems.AIR_ELEMENT));
				supplier.withPool(poolBuilder);
			}
			if (ZOMBIE.equals(id)) {
				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
						.withRolls(ConstantLootTableRange.create(1))
						.withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(1, 3)))
						.withEntry(ItemEntry.builder(MinalchemyItems.EARTH_ELEMENT));
				supplier.withPool(poolBuilder);
			}
			if (HUSK.equals(id)) {
				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
						.withRolls(ConstantLootTableRange.create(1))
						.withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(1, 3)))
						.withEntry(ItemEntry.builder(MinalchemyItems.FIRE_ELEMENT));
				supplier.withPool(poolBuilder);
			}
			if (DROWNED.equals(id)) {
				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
						.withRolls(ConstantLootTableRange.create(1))
						.withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(1, 3)))
						.withEntry(ItemEntry.builder(MinalchemyItems.WATER_ELEMENT));
				supplier.withPool(poolBuilder);
			}
		});
	}
}
