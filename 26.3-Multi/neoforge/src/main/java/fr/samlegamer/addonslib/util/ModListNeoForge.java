package fr.samlegamer.addonslib.util;

import net.neoforged.fml.ModList;

public class ModListNeoForge implements IModList
{
    @Override
    public boolean isLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
