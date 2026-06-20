package fr.samlegamer.addonslib.fuel;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.item.McwBlockItem;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.world.item.Item;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIFuels
{
    private static void initFuel(String MODID, List<String> list, McwBlockIdBase blocks)
    {
        Map<McwBlockItem, Integer> map = new HashMap<>();

        for (String mat : list) {
            for (BlockId id : blocks.blocks()) {
                final Item block = Finder.findItem(MODID, McwBlocksIdBase.replacement(id.id(), mat));

                if(block instanceof McwBlockItem mcwBlockItem)
                {
                    final int fuelTime = mcwBlockItem.getBurnTime();
                    map.put(mcwBlockItem, fuelTime);
                }
            }
        }

        FuelValueEvents.BUILD.register((builder, context) -> {
            for(Map.Entry<McwBlockItem, Integer> entry : map.entrySet())
            {
                builder.add(entry.getKey(), entry.getValue());
            }
        });
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