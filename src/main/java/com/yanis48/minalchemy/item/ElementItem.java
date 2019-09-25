package com.yanis48.minalchemy.item;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class ElementItem extends Item {
	private final ElementCategory category;

	public ElementItem(ElementCategory category, Settings settings) {
		super(settings);
		this.category = category;
	}
	
	@Environment(EnvType.CLIENT)
	public void appendTooltip(ItemStack stack, World world, List<Text> list, TooltipContext context) {
		Text category = new TranslatableText("element_category", new Object[0]).formatted(Formatting.GRAY);
		Text categoryValue = new TranslatableText("element_category." + this.category.getName(), new Object[0]).formatted(Formatting.GREEN);
		list.add(category.append(" ").append(categoryValue));
		super.appendTooltip(stack, world, list, context);
	}
}
