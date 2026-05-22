package fr.samlegamer.addonslib.registry;

import net.minecraft.world.level.block.SoundType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class RegistryUtils
{
    private RegistryUtils() {}

    public static Map<String, SoundType> makeDefaultFromList(List<String> list, SoundType soundType)
    {
        Map<String, SoundType> map = new LinkedHashMap<>();

        for(String str : list)
        {
            map.put(str, soundType);
        }

        return map;
    }
}
