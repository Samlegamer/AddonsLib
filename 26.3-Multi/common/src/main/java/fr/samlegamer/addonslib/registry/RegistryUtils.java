package fr.samlegamer.addonslib.registry;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

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

    public static BlockSetType getBlockSetType(SoundType soundType)
    {
        if(soundType == SoundType.CHERRY_WOOD) {
            return BlockSetType.CHERRY;
        }
        else if(soundType == SoundType.NETHER_WOOD) {
            return BlockSetType.CRIMSON;
        }
        else if(soundType == SoundType.BAMBOO_WOOD) {
            return BlockSetType.BAMBOO;
        }
        else {
            return BlockSetType.OAK;
        }
    }

    public static WoodType getWoodType(SoundType soundType)
    {
        if(soundType == SoundType.CHERRY_WOOD) {
            return WoodType.CHERRY;
        }
        else if(soundType == SoundType.NETHER_WOOD) {
            return WoodType.CRIMSON;
        }
        else if(soundType == SoundType.BAMBOO_WOOD) {
            return WoodType.BAMBOO;
        }
        else {
            return WoodType.OAK;
        }
    }
}
