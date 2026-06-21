package fr.samlegamer.addonslib.util;

import net.minecraftforge.fml.ModList;

public class ModListForge implements IModList
{
    @Override
    public boolean isLoaded(String modId) {
        return ModList.isLoaded(modId);
    }
}
