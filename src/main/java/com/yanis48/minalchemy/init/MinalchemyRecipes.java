package com.yanis48.minalchemy.init;

import com.yanis48.minalchemy.Minalchemy;
import com.yanis48.minalchemy.recipe.AlchemyRecipe;
import com.yanis48.minalchemy.recipe.AlchemyRecipeSerializer;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MinalchemyRecipes {
	
	public static final RecipeType<AlchemyRecipe> ALCHEMY = register("alchemy");
	
	public static final RecipeSerializer<AlchemyRecipe> ALCHEMY_SERIALIZER = register("alchemy", new AlchemyRecipeSerializer());
	
	private static <T extends Recipe<?>> RecipeType<T> register(String name) {
		return Registry.register(Registry.RECIPE_TYPE, new Identifier(Minalchemy.MOD_ID, name), new RecipeType<T>() {
			public String toString() {
				return name;
			}
		});
	}
	
	private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String name, S serializer) {
		return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Minalchemy.MOD_ID, name), serializer);
	}
}
