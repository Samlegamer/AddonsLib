package fr.samlegamer.addonslib.tab;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class APICreativeTab
{
    public static void initAllWood(String MODID, List<String> WOOD, ItemGroup tab, ModType... type)
    {
        initAllWood(MODID, WOOD, tab, "minecraft", type);
    }

    public static void initAllWood(String MODID, List<String> WOOD, ItemGroup tab, String modLoaded, ModType... type)
    {
        FabricLoader modList = FabricLoader.getInstance();
        boolean BaseModLoaded = modList.isModLoaded(modLoaded);
        Set<Block> blockSet = new HashSet<>();

        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidWood(mod);
            for (String mat : WOOD) {
                for (BlockId id : blocks.blocks()) {
                    if(modList.isModLoaded(mod.getModid()) && BaseModLoaded)
                    {
                        final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                        blockSet.add(block);
                    }
                }
            }
        }

        ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
            for(Block block : blockSet) {
                content.add(block);
            }
        });
    }

    public static void initAllLeave(String MODID, List<String> LEAVE, ItemGroup tab)
    {
        initAllLeave(MODID, LEAVE, tab, "minecraft");
    }

    public static void initAllLeave(String MODID, List<String> LEAVE, ItemGroup tab, String modLoaded)
    {
        FabricLoader modList = FabricLoader.getInstance();
        boolean BaseModLoaded = modList.isModLoaded(modLoaded);
        Set<Block> blockSet = new HashSet<>();

        final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        for (String mat : LEAVE) {
            for (BlockId id : blocks.blocks()) {
                if(modList.isModLoaded(ModType.FENCES.getModid()) && BaseModLoaded) {
                    final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    blockSet.add(block);
                }
            }
        }

        ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
            for(Block block : blockSet) {
                content.add(block);
            }
        });
    }

    public static void initAllStone(String MODID, List<String> STONE, ItemGroup tab, ModType... type)
    {
        initAllStone(MODID, STONE, tab, "minecraft", type);
    }

    public static void initAllStone(String MODID, List<String> STONE, ItemGroup tab, String modLoaded, ModType... type)
    {
        FabricLoader modList = FabricLoader.getInstance();
        boolean BaseModLoaded = modList.isModLoaded(modLoaded);
        Set<Block> blockSet = new HashSet<>();

        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidStone(mod);
            for (String mat : STONE) {
                for (BlockId id : blocks.blocks()) {
                    if(modList.isModLoaded(mod.getModid()) && BaseModLoaded) {
                        final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                        blockSet.add(block);
                    }
                }
            }
        }

        ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
            for(Block block : blockSet) {
                content.add(block);
            }
        });
    }
}
