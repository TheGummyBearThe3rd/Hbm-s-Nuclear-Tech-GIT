package com.hbm.inventory.recipes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.stream.JsonWriter;
import com.hbm.inventory.material.Mats;
import com.hbm.inventory.material.Mats.MaterialStack;
import com.hbm.inventory.recipes.loader.SerializableRecipe;
import com.hbm.items.ModItems;

import net.minecraft.item.ItemStack;

public class CrucibleRecipes extends SerializableRecipe {

	public static HashMap<Integer, CrucibleRecipe> indexMapping = new HashMap();
	public static List<CrucibleRecipe> recipes = new ArrayList();
	
	/*
	 * IMPORTANT: crucibles do not have stack size checks for the recipe's result, meaning that they can overflow if the resulting stacks are
	 * bigger than the input stacks, so make sure that material doesn't "expand". very few things do that IRL when alloying anyway.
	 */
	
	@Override
	public void registerDefaults() {
		
		recipes.add(new CrucibleRecipe(0, "crucible.steel", 1, new ItemStack(ModItems.ingot_steel))
				.inputs(new MaterialStack(Mats.MAT_IRON, 8), new MaterialStack(Mats.MAT_COAL, 8))
				.outputs(new MaterialStack(Mats.MAT_STEEL, 8)));
		
		recipes.add(new CrucibleRecipe(1, "crucible.redcopper", 1, new ItemStack(ModItems.ingot_red_copper))
				.inputs(new MaterialStack(Mats.MAT_COPPER, 8), new MaterialStack(Mats.MAT_REDSTONE, 8))
				.outputs(new MaterialStack(Mats.MAT_MINGRADE, 16)));
		
		recipes.add(new CrucibleRecipe(2, "crucible.aa", 1, new ItemStack(ModItems.ingot_advanced_alloy))
				.inputs(new MaterialStack(Mats.MAT_STEEL, 8), new MaterialStack(Mats.MAT_MINGRADE, 8))
				.outputs(new MaterialStack(Mats.MAT_ALLOY, 16)));
	}

	public static class CrucibleRecipe {
		public MaterialStack[] input;
		public MaterialStack[] output;
		private int id;
		private String name;
		public int frequency = 1;
		public ItemStack icon;
		
		public CrucibleRecipe(int id, String name, int frequency, ItemStack icon) {
			this.id = id;
			this.name = name;
			this.frequency = frequency;
			this.icon = icon;
			
			if(!indexMapping.containsKey(id)) {
				indexMapping.put(id, this);
			} else {
				throw new IllegalStateException("Crucible recipe " + name + " has been registered with duplicate id " + id + " used by " + indexMapping.get(id).name + "!");
			}
		}
		
		public CrucibleRecipe inputs(MaterialStack... input) {
			this.input = input;
			return this;
		}
		
		public CrucibleRecipe outputs(MaterialStack... output) {
			this.output = output;
			return this;
		}
		
		public int getId() {
			return this.id;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getInputAmount() {
			
			int content = 0;
			
			for(MaterialStack stack : input) {
				content += stack.amount;
			}
			
			return content;
		}
	}

	@Override
	public String getFileName() {
		return "hbmCrucible.json";
	}

	@Override
	public Object getRecipeObject() {
		return this.recipes;
	}

	@Override
	public void readRecipe(JsonElement recipe) {
		
	}

	@Override
	public void writeRecipe(Object recipe, JsonWriter writer) throws IOException {
		
	}

	@Override
	public void deleteRecipes() {
		this.indexMapping.clear();
		this.recipes.clear();
	}
}