package fr.addonslib.api.recipes;

public class CraftingIngredient
{
    private final char symbol;
    private final String name;
    private final int requiredCount;

    public CraftingIngredient(char symbol, String name, int requiredCount)
    {
        this.symbol = symbol;
        this.name = name;
        this.requiredCount = requiredCount;
    }

    public CraftingIngredient(char symbol, String name)
    {
        this(symbol, name, 1);
    }

    public char getSymbol()
    {
        return symbol;
    }

    public String getName()
    {
        return name;
    }

    public int getRequiredCount()
    {
        return requiredCount;
    }
}