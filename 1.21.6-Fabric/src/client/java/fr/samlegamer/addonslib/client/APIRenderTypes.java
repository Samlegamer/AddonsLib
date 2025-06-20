package fr.samlegamer.addonslib.client;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlockIdBase;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.ModType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.BlockRenderLayer;
import java.util.List;

@Environment(EnvType.CLIENT)
public class APIRenderTypes
{
    public static void initAllWood(String MODID, List<String> WOOD, ModType... type)
    {
        initAllWood(MODID, WOOD, BlockRenderLayer.CUTOUT, type);
    }

    public static void initAllWood(String MODID, List<String> WOOD, BlockRenderLayer renderSet, ModType... type)
    {
        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidWood(mod);
            for (String mat : WOOD) {
                for (BlockId id : blocks.blocks()) {
                    final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    BlockRenderLayerMap.putBlock(block, renderSet);
                }
            }
        }
    }

    public static void initAllLeave(String MODID, List<String> LEAVE)
    {
        initAllLeave(MODID, LEAVE, BlockRenderLayer.CUTOUT);
    }

    public static void initAllLeave(String MODID, List<String> LEAVE, BlockRenderLayer renderSet)
    {
        final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        for (String mat : LEAVE) {
            for (BlockId id : blocks.blocks()) {
                final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                BlockRenderLayerMap.putBlock(block, renderSet);
            }
        }
    }

    public static void initAllStone(String MODID, List<String> STONE, ModType... type)
    {
        initAllStone(MODID, STONE, BlockRenderLayer.CUTOUT, type);
    }

    public static void initAllStone(String MODID, List<String> STONE, BlockRenderLayer renderSet, ModType... type)
    {
        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidStone(mod);
            for (String mat : STONE) {
                for (BlockId id : blocks.blocks()) {
                    final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    BlockRenderLayerMap.putBlock(block, renderSet);
                }
            }
        }
    }
}
