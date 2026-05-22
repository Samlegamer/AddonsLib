package fr.samlegamer.addonslib.tab;

import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.util.ModListForge;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import java.util.List;
import java.util.Set;

public class APICreativeTab {

    public static void initAllWood(final CreativeModeTabEvent.BuildContents event, String MODID, List<String> WOOD, CreativeModeTab tab, ModType... type)
    {
        initAllWood(event, MODID, WOOD, "minecraft", tab, type);
    }

    public static void initAllWood(final CreativeModeTabEvent.BuildContents event, String MODID, List<String> WOOD, String modidCharged, CreativeModeTab tab, ModType... type)
    {
        Set<ItemStack> blockSet = CreativeTabUtils.getWoodItemForCreativeTab(new ModListForge(), MODID, WOOD, modidCharged, type);

        if (event.getTab() == tab) {
            event.acceptAll(blockSet);
        }
    }

    public static void initAllLeave(final CreativeModeTabEvent.BuildContents event, String MODID, List<String> LEAVE, CreativeModeTab tab)
    {
        initAllLeave(event, MODID, LEAVE, "minecraft", tab);
    }

    public static void initAllLeave(final CreativeModeTabEvent.BuildContents event, String MODID, List<String> LEAVE, String modidCharged, CreativeModeTab tab)
    {
        Set<ItemStack> blockSet = CreativeTabUtils.getHedgeItemForCreativeTab(new ModListForge(), MODID, LEAVE, modidCharged);

        if (event.getTab() == tab) {
            event.acceptAll(blockSet);
        }
    }

    public static void initAllStone(final CreativeModeTabEvent.BuildContents event, String MODID, List<String> STONE, CreativeModeTab tab, ModType... type)
    {
        initAllStone(event, MODID, STONE, "minecraft", tab, type);
    }

    public static void initAllStone(final CreativeModeTabEvent.BuildContents event, String MODID, List<String> STONE, String modidCharged, CreativeModeTab tab, ModType... type)
    {
        Set<ItemStack> blockSet = CreativeTabUtils.getStoneItemForCreativeTab(new ModListForge(), MODID, STONE, modidCharged, type);

        if (event.getTab() == tab) {
            event.acceptAll(blockSet);
        }
    }
}
