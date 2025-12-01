package fr.addonslib.api.recipes;

public class RecipesBase
{
    private final String method;
    private final String[] pattern;
    private final String unlockBlock;
    private final int count;
    private final String group;
    private final CraftingIngredient[] craftingItems;

    public RecipesBase(String method, String[] pattern, String unlockBlock, int count, String group, CraftingIngredient... craftingItems)
    {
        this.method = method;
        this.pattern = pattern;
        this.unlockBlock = unlockBlock;
        this.count = count;
        this.group = group;
        this.craftingItems = craftingItems;
    }

    public String getMethod()
    {
        return method;
    }

    public String[] getPattern()
    {
        return pattern;
    }

    public String getUnlockBlock()
    {
        return unlockBlock;
    }

    public int getCount()
    {
        return count;
    }

    public String getGroup()
    {
        return group;
    }

    public CraftingIngredient[] getCraftingItems()
    {
        return craftingItems;
    }
}