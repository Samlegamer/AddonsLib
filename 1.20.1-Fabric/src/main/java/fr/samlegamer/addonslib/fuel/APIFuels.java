package fr.samlegamer.addonslib.fuel;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlockIdBase;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.ModType;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import java.util.List;

public class APIFuels
{
    public static void initAllWood(String MODID, List<String> WOOD, ModType... type)
    {
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
                    FuelRegistry.INSTANCE.add(block, fuelTime);
                }
            }
        }
    }

    public static void initAllLeave(String MODID, List<String> LEAVE)
    {
        final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        for (String mat : LEAVE) {
            for (BlockId id : blocks.blocks()) {
                final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                FuelRegistry.INSTANCE.add(block, 300);
            }
        }
    }
}