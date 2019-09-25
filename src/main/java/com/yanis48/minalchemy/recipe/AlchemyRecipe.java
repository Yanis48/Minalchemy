package com.yanis48.minalchemy.recipe;

import com.yanis48.minalchemy.init.MinalchemyBlocks;
import com.yanis48.minalchemy.init.MinalchemyRecipes;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class AlchemyRecipe implements Recipe<CraftingInventory> {
	protected final Identifier id;
	protected final String group;
	protected final ItemStack output;
	protected final DefaultedList<Ingredient> ingredients;
	
	public AlchemyRecipe(Identifier id, String group, ItemStack output, DefaultedList<Ingredient> ingredients) {
		this.id = id;
		this.group = group;
		this.output = output;
		this.ingredients = ingredients;
	}

	public boolean matches(CraftingInventory craftingInv, World world) {
		RecipeFinder finder = new RecipeFinder();
		int int_1 = 0;
		for (int i = 0; i < craftingInv.getInvSize(); ++i) {
			ItemStack stack = craftingInv.getInvStack(i);
			if (!stack.isEmpty()) {
				++int_1;
				finder.method_20478(stack, 1);
			}
		}
		return int_1 == this.ingredients.size() && finder.findRecipe(this, null);
	}

	public ItemStack craft(CraftingInventory craftingInv) {
		return this.output.copy();
	}
	
	@Environment(EnvType.CLIENT)
	public boolean fits(int x, int y) {
		return x * y >= this.ingredients.size();
	}

	public ItemStack getOutput() {
		return this.output;
	}

	public Identifier getId() {
		return this.id;
	}
	
	public DefaultedList<Ingredient> getPreviewInputs() {
		return this.ingredients;
	}
	
	@Environment(EnvType.CLIENT)
	public String getGroup() {
		return this.group;
	}
	
	@Environment(EnvType.CLIENT)
	public ItemStack getRecipeKindIcon() {
		return new ItemStack(MinalchemyBlocks.ALCHEMY_TABLE);
	}
	
	public RecipeSerializer<?> getSerializer() {
		return MinalchemyRecipes.ALCHEMY_SERIALIZER;
	}

	public RecipeType<?> getType() {
		return MinalchemyRecipes.ALCHEMY;
	}
}
