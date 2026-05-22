package fr.samlegamer.addonslib.tab;

import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.util.ModListFabric;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import java.util.List;
import java.util.Set;

public class APICreativeTab
{
    public static void initAllWood(String MODID, List<String> WOOD, CreativeModeTab tab, ModType... type)
    {
        initAllWood(MODID, WOOD, tab, "minecraft", type);
    }

    public static void initAllWood(String MODID, List<String> WOOD, CreativeModeTab tab, String modLoaded, ModType... type)
    {
        Set<ItemStack> blockSet = CreativeTabUtils.getWoodItemForCreativeTab(new ModListFabric(), MODID, WOOD, modLoaded, type);

        ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
            for(ItemStack block : blockSet) {
                content.accept(block);
            }
        });
    }

    public static void initAllLeave(String MODID, List<String> LEAVE, CreativeModeTab tab)
    {
        initAllLeave(MODID, LEAVE, tab, "minecraft");
    }

    public static void initAllLeave(String MODID, List<String> LEAVE, CreativeModeTab tab, String modLoaded)
    {
        Set<ItemStack> blockSet = CreativeTabUtils.getHedgeItemForCreativeTab(new ModListFabric(), MODID, LEAVE, modLoaded);

        ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
            for(ItemStack block : blockSet) {
                content.accept(block);
            }
        });
    }

    public static void initAllStone(String MODID, List<String> STONE, CreativeModeTab tab, ModType... type)
    {
        initAllStone(MODID, STONE, tab, "minecraft", type);
    }

    public static void initAllStone(String MODID, List<String> STONE, CreativeModeTab tab, String modLoaded, ModType... type)
    {
        Set<ItemStack> blockSet = CreativeTabUtils.getStoneItemForCreativeTab(new ModListFabric(), MODID, STONE, modLoaded, type);

        ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
            for(ItemStack block : blockSet) {
                content.accept(block);
            }
        });
    }
}
