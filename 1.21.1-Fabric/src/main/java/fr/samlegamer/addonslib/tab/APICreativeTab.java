package fr.samlegamer.addonslib.tab;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlockIdBase;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.ModType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

import java.util.List;

@Environment(EnvType.CLIENT)
public class APICreativeTab
{
    public static void initAllWood(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab, ModType... type)
    {
        initAllWood(MODID, WOOD, tab, "minecraft", type);
    }

    public static void initAllWood(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab, String modLoaded, ModType... type)
    {
        FabricLoader modList = FabricLoader.getInstance();
        boolean BaseModLoaded = modList.isModLoaded(modLoaded);

        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidWood(mod);
            for (String mat : WOOD) {
                for (BlockId id : blocks.blocks()) {
                    if(modList.isModLoaded(mod.getModid()) && BaseModLoaded)
                    {
                        final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));

                        ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
                            content.add(block);
                        });
                    }
                }
            }
        }
    }

    public static void initAllLeave(String MODID, List<String> LEAVE, RegistryKey<ItemGroup> tab)
    {
        initAllLeave(MODID, LEAVE, tab, "minecraft");
    }

    public static void initAllLeave(String MODID, List<String> LEAVE, RegistryKey<ItemGroup> tab, String modLoaded)
    {
        FabricLoader modList = FabricLoader.getInstance();
        boolean BaseModLoaded = modList.isModLoaded(modLoaded);

        final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        for (String mat : LEAVE) {
            for (BlockId id : blocks.blocks()) {
                if(modList.isModLoaded(ModType.FENCES.getModid()) && BaseModLoaded) {
                    final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));

                    ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
                        content.add(block);
                    });
                }
            }
        }
    }

    public static void initAllStone(String MODID, List<String> STONE, RegistryKey<ItemGroup> tab, ModType... type)
    {
        initAllStone(MODID, STONE, tab, "minecraft", type);
    }

    public static void initAllStone(String MODID, List<String> STONE, RegistryKey<ItemGroup> tab, String modLoaded, ModType... type)
    {
        FabricLoader modList = FabricLoader.getInstance();
        boolean BaseModLoaded = modList.isModLoaded(modLoaded);

        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidStone(mod);
            for (String mat : STONE) {
                for (BlockId id : blocks.blocks()) {
                    if(modList.isModLoaded(mod.getModid()) && BaseModLoaded) {
                        final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));

                        ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
                            content.add(block);
                        });
                    }
                }
            }
        }
    }
}
