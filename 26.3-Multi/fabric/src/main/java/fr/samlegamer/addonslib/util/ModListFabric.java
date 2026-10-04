package fr.samlegamer.addonslib.util;

import net.fabricmc.loader.api.FabricLoader;

public class ModListFabric implements IModList
{
    @Override
    public boolean isLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
