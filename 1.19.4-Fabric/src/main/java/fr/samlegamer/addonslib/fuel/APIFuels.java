package fr.samlegamer.addonslib.fuel;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.item.McwBlockItem;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.item.Item;

import java.util.List;

public class APIFuels
{
    private static void initFuel(String MODID, List<String> list, McwBlockIdBase blocks)
    {
        for (String mat : list) {
            for (BlockId id : blocks.blocks()) {
                final Item block = Finder.findItem(MODID, McwBlocksIdBase.replacement(id.id(), mat));

                if(block instanceof McwBlockItem mcwBlockItem)
                {
                    final int fuelTime = mcwBlockItem.getBurnTime();
                    FuelRegistry.INSTANCE.add(mcwBlockItem, fuelTime);
                }
            }
        }
    }

    public static void initAllWood(String MODID, List<String> WOOD, ModType... type)
    {
        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidWood(mod);
            initFuel(MODID, WOOD, blocks);
        }
    }

    public static void initAllLeave(String MODID, List<String> LEAVE)
    {
        final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        initFuel(MODID, LEAVE, blocks);
    }
}