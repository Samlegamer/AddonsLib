package fr.samlegamer.addonslib.fuel;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.block.Block;
import java.util.*;

public class APIFuels
{
    public static void initAllWood(String MODID, List<String> WOOD, ModType... type)
    {
        Map<Block, Integer> blockSet = new HashMap<>();

        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidWood(mod);
            for (String mat : WOOD) {
                for (BlockId id : blocks.blocks()) {
                    final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    final int fuelTime;
                    if(id.id().contains("planks_path"))
                    {
                        fuelTime = 50;
                    }
                    else
                    {
                        fuelTime = 300;
                    }
                    blockSet.put(block, fuelTime);
                }
            }
        }

        FuelRegistryEvents.BUILD.register((builder, context) -> {
            for(Map.Entry<Block, Integer> entry : blockSet.entrySet())
            {
                builder.add(entry.getKey(), entry.getValue());
            }
        });
    }

    public static void initAllLeave(String MODID, List<String> LEAVE)
    {
        Set<Block> blockSet = new HashSet<>();

        final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        for (String mat : LEAVE) {
            for (BlockId id : blocks.blocks()) {
                final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                blockSet.add(block);
            }
        }

        FuelRegistryEvents.BUILD.register((builder, context) -> {
            for(Block block : blockSet)
            {
                builder.add(block, 300);
            }
        });
    }
}