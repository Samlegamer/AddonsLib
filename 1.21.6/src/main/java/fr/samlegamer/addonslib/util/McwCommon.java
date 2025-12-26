package fr.samlegamer.addonslib.util;

import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.addonslib.api.furnitures.FurnitureStorageAdd;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import java.util.*;

/*
 * Is used in McwFurnituresBOP 1.21.1
 * Fix Placing Furnitures Crash
 */
public class McwCommon
{
    private static void addCompatibleBlocks(Block... blocks)
    {
        Set<Block> currentBlocks = new HashSet<>(Finder.findTileEntity("mcwfurnitures", "furniture_storage").validBlocks);
        Collections.addAll(currentBlocks, blocks);
        Finder.findTileEntity(ModType.FURNITURES.getModid(), "furniture_storage").validBlocks = Set.copyOf(currentBlocks);
    }

    public static void addCompatibleBlocksToFurnitureStorage(FMLCommonSetupEvent event, String MODID, List<String> MAT)
    {
        if (ModList.get().isLoaded(ModType.FURNITURES.getModid()))
        {
            List<String> furnitureStorage = FurnitureStorageAdd.getForge();
            Set<Block> blocks = new HashSet<>();

            for(String furn : furnitureStorage)
            {
                for(String mat : MAT)
                {
                    Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(furn, mat));
                    if(block != null)
                    {
                        blocks.add(block);
                    }
                }
            }

            addCompatibleBlocks(Finder.listToArray(blocks.stream().toList()));
        }
    }
}
