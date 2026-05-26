package fr.samlegamer.addonslib.tab;

import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.util.ModListForge;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class IconRandomForge extends IconRandom
{
    public static ItemStack buildIcon(Block roofsIcon, Block fencesIcon, Block furnituresIcon, Block bridgesIcon, Block windowsIcon, Block doorsIcon,
                                      Block trapdoorsIcon, Block pathsIcon, Block stairsIcon, ModType... types) {
        return buildIcon(new ModListForge(), roofsIcon, fencesIcon, furnituresIcon, bridgesIcon, windowsIcon, doorsIcon, trapdoorsIcon, pathsIcon, stairsIcon, types);
    }
}