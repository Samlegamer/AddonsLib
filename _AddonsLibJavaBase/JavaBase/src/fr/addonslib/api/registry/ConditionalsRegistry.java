package fr.addonslib.api.registry;

public final class ConditionalsRegistry
{
    private ConditionalsRegistry() {}

    public static boolean isBlockDefaultState(String reflectedLocation)
    {
        return reflectedLocation.contains("StorageCounter") ||
                reflectedLocation.endsWith("Cabinet") ||
                reflectedLocation.contains("Lower") ||
                reflectedLocation.contains("Steep") ||
                reflectedLocation.contains("BaseRoof");
    }

    public static boolean isBlockSetType(String reflectedLocation)
    {
        return reflectedLocation.contains("StableDoor") && reflectedLocation.contains("JapaneseDoors");
    }

    public static boolean isFence(String reflectedLocation)
    {
        return reflectedLocation.contains("FenceBlock");
    }

    public static boolean isFenceGate(String reflectedLocation)
    {
        return reflectedLocation.contains("FenceGateBlock");
    }

    public static boolean isTrapdoor(String id)
    {
        return id.contains("trapdoor");
    }

    public static boolean isDoor(String id)
    {
        return !id.contains("trapdoor") && id.contains("door");
    }
}
