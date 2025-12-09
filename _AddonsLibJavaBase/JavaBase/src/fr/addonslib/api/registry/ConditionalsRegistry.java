package fr.addonslib.api.registry;

public final class ConditionalsRegistry
{
    private ConditionalsRegistry() {}

    public static boolean isBlockDefaultState(String version, String reflectedLocation)
    {
        boolean b1 = reflectedLocation.contains("StorageCounter") || reflectedLocation.endsWith("CupboardCounter");
        boolean b2 = reflectedLocation.endsWith("CabinetHinge");
        boolean b3 = ((!reflectedLocation.endsWith("BookCabinet")) && reflectedLocation.endsWith("Cabinet"));
        boolean b4 = reflectedLocation.contains("Lower") || reflectedLocation.contains("Steep") || reflectedLocation.contains("BaseRoof");

        boolean b5 = false;

        if(version.startsWith("1.16.5"))
        {
            b5 = !reflectedLocation.endsWith("BookCabinetHinge");
        }
        else if(version.startsWith("1.17.1"))
        {
            b5 = !reflectedLocation.endsWith("CabinetHinge") && !reflectedLocation.endsWith("CupboardCounter");
        }

        return  (b1 || b2 || b3 || b4) && b5;
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
