package fr.addonslib.api.client;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class McwColors
{
    private final Map<String, Integer> NoColorLeaves;
    public static final int DEFAULT_LEAVES_COLOR = -12012264;

    public McwColors(Map<String, Integer> NoColorLeaves) {
        this.NoColorLeaves = NoColorLeaves;
    }

    public McwColors(List<String> NoColorLeaves) {
        this(listToMap(NoColorLeaves));
    }

    private static Map<String, Integer> listToMap(List<String> noColorLeaves) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String str : noColorLeaves) {
            map.put(str, DEFAULT_LEAVES_COLOR);
        }
        return map;
    }

    public Map<String, Integer> getNoColorLeaves() {
        return NoColorLeaves;
    }
}