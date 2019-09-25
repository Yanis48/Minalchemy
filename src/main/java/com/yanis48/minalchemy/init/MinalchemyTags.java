package com.yanis48.minalchemy.init;

import com.yanis48.minalchemy.Minalchemy;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class MinalchemyTags {
	
	public static final Tag<Item> ELEMENTS = register("elements");
	
	private static Tag<Item> register(String id) {
		return TagRegistry.item(new Identifier(Minalchemy.MOD_ID, id));
	}
}
