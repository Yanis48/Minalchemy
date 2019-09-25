package com.yanis48.minalchemy.init;

import com.yanis48.minalchemy.Minalchemy;
import com.yanis48.minalchemy.item.ElementCategory;
import com.yanis48.minalchemy.item.ElementItem;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MinalchemyItems {
	
	public static final Item ALCHEMY_TABLE = register("alchemy_table", new BlockItem(MinalchemyBlocks.ALCHEMY_TABLE, new Item.Settings().maxCount(64).group(Minalchemy.MINALCHEMY)));
	
	public static final Item AIR_ELEMENT = registerElement("air_element", ElementCategory.BASIC);
	public static final Item EARTH_ELEMENT = registerElement("earth_element", ElementCategory.BASIC);
	public static final Item FIRE_ELEMENT = registerElement("fire_element", ElementCategory.BASIC);
	public static final Item WATER_ELEMENT = registerElement("water_element", ElementCategory.BASIC);
	
	public static final Item ANIMAL_ELEMENT = registerElement("animal_element", ElementCategory.ANIMALS);
	public static final Item ANT_ELEMENT = registerElement("ant_element", ElementCategory.INSECTS);
	public static final Item AQUARIUM_ELEMENT = registerElement("aquarium_element", ElementCategory.CONTAINERS);
	public static final Item ATMOSPHERE_ELEMENT = registerElement("atmosphere_element", ElementCategory.SPACE);
	public static final Item BACTERIA_ELEMENT = registerElement("bacteria_element", ElementCategory.BIOLOGY);
	public static final Item BEACH_ELEMENT = registerElement("beach_element", ElementCategory.GEOLOGY);
	public static final Item BEE_ELEMENT = registerElement("bee_element", ElementCategory.INSECTS);
	public static final Item BELL_ELEMENT = registerElement("bell_element", ElementCategory.TOOLS);
	public static final Item BIRD_ELEMENT = registerElement("bird_element", ElementCategory.BIRDS);
	public static final Item BLADE_ELEMENT = registerElement("blade_element", ElementCategory.TOOLS);
	public static final Item BRICK_ELEMENT = registerElement("brick_element", ElementCategory.MATERIALS);
	public static final Item BUTTERFLY_ELEMENT = registerElement("butterfly_element", ElementCategory.INSECTS);
	public static final Item CACTUS_ELEMENT = registerElement("cactus_element", ElementCategory.PLANTS);
	public static final Item CAMEL_ELEMENT = registerElement("camel_element", ElementCategory.ANIMALS);
	public static final Item CITY_ELEMENT = registerElement("city_element", ElementCategory.CONSTRUCTION);
	public static final Item CLOUD_ELEMENT = registerElement("cloud_element", ElementCategory.WEATHER);
	public static final Item CONTINENT_ELEMENT = registerElement("continent_element", ElementCategory.GEOLOGY);
	public static final Item DESERT_ELEMENT = registerElement("desert_element", ElementCategory.GEOLOGY);
	public static final Item DUCK_ELEMENT = registerElement("duck_element", ElementCategory.BIRDS);
	public static final Item DUNE_ELEMENT = registerElement("dune_element", ElementCategory.GEOLOGY);
	public static final Item DUST_ELEMENT = registerElement("dust_element", ElementCategory.AIR);
	public static final Item EARTHQUAKE_ELEMENT = registerElement("earthquake_element", ElementCategory.GEOLOGY);
	public static final Item EGG_ELEMENT = registerElement("egg_element", ElementCategory.BIOLOGY);
	public static final Item ENERGY_ELEMENT = registerElement("energy_element", ElementCategory.FORCES);
	public static final Item FISH_ELEMENT = registerElement("fish_element", ElementCategory.ANIMALS);
	public static final Item FLOWER_ELEMENT = registerElement("flower_element", ElementCategory.PLANTS);
	public static final Item FOG_ELEMENT = registerElement("fog_element", ElementCategory.WEATHER);
	public static final Item FROG_ELEMENT = registerElement("frog_element", ElementCategory.ANIMALS);
	public static final Item GALAXY_CLUSTER_ELEMENT = registerElement("galaxy_cluster_element", ElementCategory.SPACE);
	public static final Item GALAXY_ELEMENT = registerElement("galaxy_element", ElementCategory.SPACE);
	public static final Item GARDEN_ELEMENT = registerElement("garden_element", ElementCategory.PLANTS);
	public static final Item GLASS_ELEMENT = registerElement("glass_element", ElementCategory.MINERALS);
	public static final Item GLASSES_ELEMENT = registerElement("glasses_element", ElementCategory.TOOLS);
	public static final Item GOLD_ELEMENT = registerElement("gold_element", ElementCategory.MATERIALS);
	public static final Item GRASS_ELEMENT = registerElement("grass_element", ElementCategory.PLANTS);
	public static final Item GREENHOUSE_ELEMENT = registerElement("greenhouse_element", ElementCategory.CONTAINERS);
	public static final Item HAY_BALE_ELEMENT = registerElement("hay_bale_element", ElementCategory.FOOD);
	public static final Item HAY_ELEMENT = registerElement("hay_element", ElementCategory.FOOD);
	public static final Item HEAT_ELEMENT = registerElement("heat_element", ElementCategory.FORCES);
	public static final Item HONEY_ELEMENT = registerElement("honey_element", ElementCategory.FOOD);
	public static final Item HORSE_ELEMENT = registerElement("horse_element", ElementCategory.ANIMALS);
	public static final Item HORSESHOE_ELEMENT = registerElement("horseshoe_element", ElementCategory.TOOLS);
	public static final Item HOURGLASS_ELEMENT = registerElement("hourglass_element", ElementCategory.TOOLS);
	public static final Item HOUSE_ELEMENT = registerElement("house_element", ElementCategory.CONSTRUCTION);
	public static final Item LAKE_ELEMENT = registerElement("lake_element", ElementCategory.WATER);
	public static final Item LAND_ELEMENT = registerElement("land_element", ElementCategory.GEOLOGY);
	public static final Item LAVA_ELEMENT = registerElement("lava_element", ElementCategory.GEOLOGY);
	public static final Item LIFE_ELEMENT = registerElement("life_element", ElementCategory.BIOLOGY);
	public static final Item LIZARD_ELEMENT = registerElement("lizard_element", ElementCategory.ANIMALS);
	public static final Item METAL_ELEMENT = registerElement("metal_element", ElementCategory.MATERIALS);
	public static final Item MIST_ELEMENT = registerElement("mist_element", ElementCategory.WEATHER);
	public static final Item MUD_ELEMENT = registerElement("mud_element", ElementCategory.GEOLOGY);
	public static final Item OASIS_ELEMENT = registerElement("oasis_element", ElementCategory.GEOLOGY);
	public static final Item OBSIDIAN_ELEMENT = registerElement("obsidian_element", ElementCategory.MINERALS);
	public static final Item OCEAN_ELEMENT = registerElement("ocean_element", ElementCategory.WATER);
	public static final Item PHOENIX_ELEMENT = registerElement("phoenix_element", ElementCategory.BIRDS);
	public static final Item PIG_ELEMENT = registerElement("pig_element", ElementCategory.ANIMALS);
	public static final Item PIGEON_ELEMENT = registerElement("pigeon_element", ElementCategory.BIRDS);
	public static final Item PLANET_ELEMENT = registerElement("planet_element", ElementCategory.SPACE);
	public static final Item PLANT_ELEMENT = registerElement("plant_element", ElementCategory.PLANTS);
	public static final Item POND_ELEMENT = registerElement("pond_element", ElementCategory.WATER);
	public static final Item PRESSURE_ELEMENT = registerElement("pressure_element", ElementCategory.FORCES);
	public static final Item PRIMORDIAL_SOUP_ELEMENT = registerElement("primordial_soup_element", ElementCategory.BIOLOGY);
	public static final Item PUDDLE_ELEMENT = registerElement("puddle_element", ElementCategory.WATER);
	public static final Item PYRAMID_ELEMENT = registerElement("pyramid_element", ElementCategory.CONSTRUCTION);
	public static final Item RAIN_ELEMENT = registerElement("rain_element", ElementCategory.WEATHER);
	public static final Item RAINBOW_ELEMENT = registerElement("rainbow_element", ElementCategory.WEATHER);
	public static final Item REED_ELEMENT = registerElement("reed_element", ElementCategory.PLANTS);
	public static final Item ROSE_ELEMENT = registerElement("rose_element", ElementCategory.PLANTS);
	public static final Item SALT_ELEMENT = registerElement("salt_element", ElementCategory.MINERALS);
	public static final Item SAND_ELEMENT = registerElement("sand_element", ElementCategory.GEOLOGY);
	public static final Item SANDSTORM_ELEMENT = registerElement("sandstorm_element", ElementCategory.WEATHER);
	public static final Item SCORPION_ELEMENT = registerElement("scorpion_element", ElementCategory.INSECTS);
	public static final Item SEA_ELEMENT = registerElement("sea_element", ElementCategory.WATER);
	public static final Item SEAGULL_ELEMENT = registerElement("seagull_element", ElementCategory.BIRDS);
	public static final Item SEAWEED_ELEMENT = registerElement("seaweed_element", ElementCategory.PLANTS);
	public static final Item SMOG_ELEMENT = registerElement("smog_element", ElementCategory.WEATHER);
	public static final Item SMOKE_ELEMENT = registerElement("smoke_element", ElementCategory.AIR);
	public static final Item SOIL_ELEMENT = registerElement("soil_element", ElementCategory.GEOLOGY);
	public static final Item SOLAR_SYSTEM_ELEMENT = registerElement("solar_system_element", ElementCategory.SPACE);
	public static final Item SOUND_ELEMENT = registerElement("sound_element", ElementCategory.FORCES);
	public static final Item STEAM_ELEMENT = registerElement("steam_element", ElementCategory.WATER);
	public static final Item STONE_ELEMENT = registerElement("stone_element", ElementCategory.GEOLOGY);
	public static final Item SUN_ELEMENT = registerElement("sun_element", ElementCategory.SPACE);
	public static final Item SUNFLOWER_ELEMENT = registerElement("sunflower_element", ElementCategory.PLANTS);
	public static final Item SUNGLASSES_ELEMENT = registerElement("sunglasses_element", ElementCategory.TOOLS);
	public static final Item SWIM_GOGGLES_ELEMENT = registerElement("swim_goggles_element", ElementCategory.TOOLS);
	public static final Item TORNADO_ELEMENT = registerElement("tornado_element", ElementCategory.WEATHER);
	public static final Item TURTLE_ELEMENT = registerElement("turtle_element", ElementCategory.ANIMALS);
	public static final Item UNIVERSE_ELEMENT = registerElement("universe_element", ElementCategory.SPACE);
	public static final Item VILLAGE_ELEMENT = registerElement("village_element", ElementCategory.CONSTRUCTION);
	public static final Item VOLCANO_ELEMENT = registerElement("volcano_element", ElementCategory.GEOLOGY);
	public static final Item WALL_ELEMENT = registerElement("wall_element", ElementCategory.CONSTRUCTION);
	public static final Item WATER_LILY_ELEMENT = registerElement("water_lily_element", ElementCategory.PLANTS);
	public static final Item WAVE_ELEMENT = registerElement("wave_element", ElementCategory.FORCES);
	public static final Item WIND_ELEMENT = registerElement("wind_element", ElementCategory.WEATHER);
	
	private static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(Minalchemy.MOD_ID, name), item);
	}
	
	private static Item registerElement(String name, ElementCategory category) {
		return register(name, new ElementItem(category, new Item.Settings().maxCount(64).group(Minalchemy.MINALCHEMY)));
	}
}
