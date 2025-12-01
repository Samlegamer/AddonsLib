package fr.addonslib.api.data;

import fr.addonslib.api.recipes.RecipesBase;

public class BlockId {
    private final String id;
    private final ReflectedLocation reflectedLocation;
    private final RecipesBase[] recipes;

    public BlockId(String id, ReflectedLocation reflectedLocation, RecipesBase... recipes) {
        this.id = id;
        this.reflectedLocation = reflectedLocation;
        this.recipes = recipes;
    }

    public String id() {
        return id;
    }

    public ReflectedLocation reflectedLocation() {
        return reflectedLocation;
    }

    public RecipesBase[] recipes() {
        return recipes;
    }
}