package fr.samlegamer.addonslib.tab;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlockIdBase;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.ModType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import java.util.List;

public class APICreativeTab {

    public static void initAllWood(final BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab, ModType... type)
    {
        initAllWood(event, MODID, WOOD, "minecraft", tab, type);
    }

    public static void initAllWood(final BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, String modidCharged, CreativeModeTab tab, ModType... type)
    {
        ModList modList = ModList.get();

        for (ModType mod : type) {
            if (event.getTab() == tab && modList.isLoaded(mod.getModid()) && modList.isLoaded(modidCharged)) {
                final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidWood(mod);

                for (String mat : WOOD) {
                    assert blocks != null;
                    for (BlockId id : blocks.blocks()) {
                        final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                        event.accept(block);
                    }
                }
            }
        }
    }

    public static void initAllLeave(final BuildCreativeModeTabContentsEvent event, String MODID, List<String> LEAVE, CreativeModeTab tab)
    {
        initAllLeave(event, MODID, LEAVE, "minecraft", tab);
    }

    public static void initAllLeave(final BuildCreativeModeTabContentsEvent event, String MODID, List<String> LEAVE, String modidCharged, CreativeModeTab tab)
    {
        ModList modList = ModList.get();

        if (event.getTab() == tab && modList.isLoaded(ModType.FENCES.getModid()) && modList.isLoaded(modidCharged)) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);

            for (String mat : LEAVE) {
                assert blocks != null;
                for (BlockId id : blocks.blocks()) {
                    final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    event.accept(block);
                }
            }
        }
    }

    public static void initAllStone(final BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, CreativeModeTab tab, ModType... type)
    {
        initAllStone(event, MODID, STONE, "minecraft", tab, type);
    }

    public static void initAllStone(final BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, String modidCharged, CreativeModeTab tab, ModType... type)
    {
        ModList modList = ModList.get();

        for (ModType mod : type) {
            if (event.getTab() == tab && modList.isLoaded(mod.getModid()) && modList.isLoaded(modidCharged)) {
                final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidStone(mod);

                for (String mat : STONE) {
                    assert blocks != null;
                    for (BlockId id : blocks.blocks()) {
                        final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                        event.accept(block);
                    }
                }
            }
        }
    }
}
