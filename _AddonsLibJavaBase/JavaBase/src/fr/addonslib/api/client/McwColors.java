package fr.addonslib.api.client;

import java.util.HashMap;
import java.util.Map;

public final class McwColors
{
    private static final Map<String, Integer> NoColorLeaves = new HashMap<>();

    McwColors() {}

    public static void addColorLeaves(String modid, String name, int color)
    {
        String block = modid + ":" + name;
        NoColorLeaves.put(block, color);
    }

    public static void addColorLeaves(String modid, String name)
    {
        addColorLeaves(modid, name, -12012264);
    }

    public static Map<String, Integer> getNoColorLeaves() {
        return NoColorLeaves;
    }
}