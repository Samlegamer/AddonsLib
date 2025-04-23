package fr.samlegamer.addonslib.client;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlockIdBase;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.ModType;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.List;

public class APIRenderTypes
{
    public static void initAllWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, ModType... type)
    {
        initAllWood(event, MODID, WOOD, RenderType.cutout(), type);
    }

    public static void initAllWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet, ModType... type)
    {
        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidWood(mod);
            for (String mat : WOOD) {
                for (BlockId id : blocks.blocks()) {
                    final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    RenderTypeLookup.setRenderLayer(block, renderSet);
                }
            }
        }
    }

    public static void initAllLeave(final FMLClientSetupEvent event, String MODID, List<String> LEAVE)
    {
        initAllLeave(event, MODID, LEAVE, RenderType.cutout());
    }

    public static void initAllLeave(final FMLClientSetupEvent event, String MODID, List<String> LEAVE, RenderType renderSet)
    {
        final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        for (String mat : LEAVE) {
            for (BlockId id : blocks.blocks()) {
                final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                RenderTypeLookup.setRenderLayer(block, renderSet);
            }
        }
    }

    public static void initAllStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, ModType... type)
    {
        initAllStone(event, MODID, STONE, RenderType.cutout(), type);
    }

    public static void initAllStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet, ModType... type)
    {
        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidStone(mod);
            for (String mat : STONE) {
                for (BlockId id : blocks.blocks()) {
                    final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    RenderTypeLookup.setRenderLayer(block, renderSet);
                }
            }
        }
    }
}
