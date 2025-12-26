package fr.samlegamer.addonslib.client;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class APIRenderTypes
{
    public static void initAllWood(String MODID, List<String> WOOD, ModType... type)
    {
        initAllWood(MODID, WOOD, RenderLayer.getCutout(), type);
    }

    public static void initAllWood(String MODID, List<String> WOOD, RenderLayer renderSet, ModType... type)
    {
        List<Block> renders = new ArrayList<>();

        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidWood(mod);
            for (String mat : WOOD) {
                for (BlockId id : blocks.blocks()) {
                    final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    renders.add(block);
                }
            }
        }
        BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, Finder.listToArray(renders));
    }

    public static void initAllLeave(String MODID, List<String> LEAVE)
    {
        initAllLeave(MODID, LEAVE, RenderLayer.getCutout());
    }

    public static void initAllLeave(String MODID, List<String> LEAVE, RenderLayer renderSet)
    {
        List<Block> renders = new ArrayList<>();

        final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        for (String mat : LEAVE) {
            for (BlockId id : blocks.blocks()) {
                final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                renders.add(block);
            }
        }
        BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, Finder.listToArray(renders));
    }

    public static void initAllStone(String MODID, List<String> STONE, ModType... type)
    {
        initAllStone(MODID, STONE, RenderLayer.getCutout(), type);
    }

    public static void initAllStone(String MODID, List<String> STONE, RenderLayer renderSet, ModType... type)
    {
        List<Block> renders = new ArrayList<>();

        for(ModType mod : type) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidStone(mod);
            for (String mat : STONE) {
                for (BlockId id : blocks.blocks()) {
                    final Block block = Finder.findBlock(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    renders.add(block);
                }
            }
        }
        BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, Finder.listToArray(renders));
    }
}
