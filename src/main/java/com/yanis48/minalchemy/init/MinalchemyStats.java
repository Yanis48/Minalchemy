package com.yanis48.minalchemy.init;

import com.yanis48.minalchemy.Minalchemy;

import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MinalchemyStats {
	
	public static final Identifier INTERACT_WITH_ALCHEMY_TABLE = register("interact_with_alchemy_table", StatFormatter.DEFAULT);
	
	private static Identifier register(String name, StatFormatter formatter) {
		Identifier identifier = new Identifier(Minalchemy.MOD_ID, name);
		Registry.register(Registry.CUSTOM_STAT, name, identifier);
		Stats.CUSTOM.getOrCreateStat(identifier, formatter);
		return identifier;
	}
}
