package com.yanis48.minalchemy.item;

public enum ElementCategory {
	
	AIR ("air"),
	ANIMALS ("animals"),
	BASIC ("basic"),
	BIOLOGY ("biology"),
	BIRDS ("birds"),
	CONSTRUCTION ("construction"),
	CONTAINERS ("containers"),
	FOOD ("food"),
	FORCES ("forces"),
	GEOLOGY ("geology"),
	INSECTS ("insects"),
	MATERIALS ("materials"),
	MINERALS ("minerals"),
	PLANTS ("plants"),
	SPACE ("space"),
	TOOLS ("tools"),
	WATER ("water"),
	WEATHER ("weather");
	
	private final String name;
	
	private ElementCategory(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
