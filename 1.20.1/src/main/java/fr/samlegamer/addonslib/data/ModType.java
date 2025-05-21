package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.bridges.Bridges;
import fr.samlegamer.addonslib.door.Doors;
import fr.samlegamer.addonslib.fences.Fences;
import fr.samlegamer.addonslib.furnitures.Furnitures;
import fr.samlegamer.addonslib.path.Paths;
import fr.samlegamer.addonslib.roofs.Roofs;
import fr.samlegamer.addonslib.stairs.Stairs;
import fr.samlegamer.addonslib.trapdoor.Trapdoors;
import fr.samlegamer.addonslib.windows.Windows;

public enum ModType {
    ROOFS(Roofs.modid), FENCES(Fences.modid), BRIDGES(Bridges.modid), FURNITURES(Furnitures.modid),
    WINDOWS(Windows.modid), DOORS(Doors.modid), TRAPDOORS(Trapdoors.modid), PATHS(Paths.modid), STAIRS(Stairs.modid);

    private final String modid;

    ModType(String modid)
    {
        this.modid = modid;
    }

    public final String getModid()
    {
        return this.modid;
    }
}