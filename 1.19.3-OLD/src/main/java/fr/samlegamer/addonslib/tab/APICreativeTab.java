package fr.samlegamer.addonslib.tab;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.ModList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class APICreativeTab {

    public static void initAllWood(final CreativeModeTabEvent.BuildContents event, String MODID, List<String> WOOD, CreativeModeTab tab, ModType... type)
    {
        initAllWood(event, MODID, WOOD, "minecraft", tab, type);
    }

    public static void initAllWood(final CreativeModeTabEvent.BuildContents event, String MODID, List<String> WOOD, String modidCharged, CreativeModeTab tab, ModType... type)
    {
        ModList modList = ModList.get();
        Set<ItemStack> blockSet = new LinkedHashSet<>();

        for (ModType mod : type) {
            if (modList.isLoaded(mod.getModid()) && modList.isLoaded(modidCharged)) {
                final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidWood(mod);

                for (String mat : WOOD) {
                    for (BlockId id : blocks.blocks()) {
                        final Item block = Finder.findItem(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                        blockSet.add(block.getDefaultInstance());
                    }
                }
            }
        }

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
        ModList modList = ModList.get();
        Set<ItemStack> blockSet = new LinkedHashSet<>();

        if (modList.isLoaded(ModType.FENCES.getModid()) && modList.isLoaded(modidCharged)) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);

            for (String mat : LEAVE) {
                for (BlockId id : blocks.blocks()) {
                    final Item block = Finder.findItem(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    blockSet.add(block.getDefaultInstance());
                }
            }
        }

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
        ModList modList = ModList.get();
        Set<ItemStack> blockSet = new LinkedHashSet<>();

        for (ModType mod : type) {
            if (modList.isLoaded(mod.getModid()) && modList.isLoaded(modidCharged)) {
                final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidStone(mod);

                for (String mat : STONE) {
                    for (BlockId id : blocks.blocks()) {
                        final Item block = Finder.findItem(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                        blockSet.add(block.getDefaultInstance());
                    }
                }
            }
        }

        if (event.getTab() == tab) {
            event.acceptAll(blockSet);
        }
    }
}
