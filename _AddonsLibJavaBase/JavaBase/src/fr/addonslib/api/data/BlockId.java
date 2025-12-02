package fr.addonslib.api.data;

import fr.addonslib.api.recipes.RecipesBase;
import fr.addonslib.api.tags.Tags;

public class BlockId {
    private final String id;
    private final ReflectedLocation reflectedLocation;
    private final Tags tags;
    private final RecipesBase[] recipes;

    public BlockId(String id, ReflectedLocation reflectedLocation, Tags tags, RecipesBase... recipes) {
        this.id = id;
        this.reflectedLocation = reflectedLocation;
        this.tags = tags;
        this.recipes = recipes;
    }

    public String id() {
        return id;
    }

    public ReflectedLocation reflectedLocation() {
        return reflectedLocation;
    }

    public Tags tags() {
        return tags;
    }

    public RecipesBase[] recipes() {
        return recipes;
    }
}