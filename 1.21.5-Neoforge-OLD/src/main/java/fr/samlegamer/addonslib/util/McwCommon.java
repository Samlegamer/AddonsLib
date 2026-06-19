package fr.samlegamer.addonslib.util;

import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.addonslib.api.furnitures.FurnitureStorageAdd;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import java.util.*;

/*
 * Is used in McwFurnituresBOP 1.21.1
 * Fix Placing Furnitures Crash
 */
public class McwCommon
{
    private static void addCompatibleBlocks(BlockEntityTypeAddBlocksEvent event, Block... blocks)
    {
        event.modify(Finder.findTileEntity(ModType.FURNITURES.getModid(), "furniture_storage"), blocks);
    }

    public static void addCompatibleBlocksToFurnitureStorage(BlockEntityTypeAddBlocksEvent event, String MODID, List<String> MAT)
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

            addCompatibleBlocks(event, Finder.listToArray(blocks.stream().toList()));
        }
    }
}
