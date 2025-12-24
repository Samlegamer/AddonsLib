package fr.samlegamer.addonslib.util;

import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.addonslib.api.furnitures.FurnitureStorageAdd;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import java.lang.reflect.Field;
import java.util.*;

/*
 * Is used in McwFurnituresBOP 1.21.1
 * Fix Placing Furnitures Crash
 */
public class McwCommon
{
    private static void addCompatibleBlocks(Set<Block> blocks) {
        try {
            Class<?> furnitureClass = Class.forName("net.kikoz.mcwfurnitures.MacawsFurniture");

            Field blockEntityField = furnitureClass.getField("FURNITURE_BLOCK_ENTITY");

            BlockEntityType<?> furnitureBlockEntity = (BlockEntityType<?>) blockEntityField.get(BlockEntityType.class);

            if (furnitureBlockEntity != null) {
                for (Block b : blocks) {
                    furnitureBlockEntity.addSupportedBlock(b);
                }
            }
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            AddonsLib.LOGGER.error(e);
        }
    }

    public static void addCompatibleBlocksToFurnitureStorage(String MODID, List<String> MAT)
    {
        if (FabricLoader.getInstance().isModLoaded(ModType.FURNITURES.getModid()))
        {
            List<String> furnitureStorage = FurnitureStorageAdd.getFabric();
            Set<Block> blocks = new HashSet<>();

            for(String furn : furnitureStorage)
            {
                for(String mat : MAT)
                {
                    Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(furn, mat));
                    blocks.add(block);
                }
            }

            addCompatibleBlocks(blocks);
        }
    }
}
