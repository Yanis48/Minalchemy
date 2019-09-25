package com.yanis48.minalchemy.recipe;

import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.PacketByteBuf;

@SuppressWarnings("rawtypes")
public class AlchemyRecipeSerializer implements RecipeSerializer<AlchemyRecipe> {

	@Override
	public AlchemyRecipe read(Identifier id, JsonObject json) {
		String group = JsonHelper.getString(json, "group", "");
		DefaultedList<Ingredient> ingredients = getIngredients(JsonHelper.getArray(json, "ingredients"));
		if (ingredients.isEmpty()) {
			throw new JsonParseException("No ingredients for alchemy recipe");
		} else if (ingredients.size() < 2) {
			throw new JsonParseException("Not enough ingredients for alchemy recipe");
		} else if (ingredients.size() > 2) {
			throw new JsonParseException("Too many ingredients for alchemy recipe");
		} else {
			ItemStack result = ShapedRecipe.getItemStack(JsonHelper.getObject(json, "result"));
			return new AlchemyRecipe(id, group, result, ingredients);
		}
	}

	@Override
	public AlchemyRecipe read(Identifier id, PacketByteBuf buf) {
		String group = buf.readString(32767);
		int ingredientSize = buf.readVarInt();
		DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(ingredientSize, Ingredient.EMPTY);
		for (int i = 0; i < ingredients.size(); ++i) {
			ingredients.set(i, Ingredient.fromPacket(buf));
		}
		ItemStack result = buf.readItemStack();
		return new AlchemyRecipe(id, group, result, ingredients);
	}
	
	@Override
	public void write(PacketByteBuf buf, AlchemyRecipe recipe) {
		buf.writeString(recipe.group);
		buf.writeVarInt(recipe.ingredients.size());
		Iterator i = recipe.ingredients.iterator();
		while (i.hasNext()) {
			Ingredient ingredient = (Ingredient) i.next();
			ingredient.write(buf);
		}
		buf.writeItemStack(recipe.output);
	}
	
	private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
		DefaultedList<Ingredient> ingredients = DefaultedList.of();
		for (int i = 0; i < json.size(); ++i) {
			Ingredient ingredient = Ingredient.fromJson(json.get(i));
			if (!ingredient.isEmpty()) {
				ingredients.add(ingredient);
			}
		}
		return ingredients;
	}
}
