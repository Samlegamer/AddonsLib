package fr.samlegamer.addonslib.client;

import java.util.Map;

import fr.addonslib.api.client.McwColors;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

@OnlyIn(Dist.CLIENT)
public class ColorRegistry {

    private final McwColors mcwColors;

    public ColorRegistry(McwColors mcwColors) {
        this.mcwColors = mcwColors;
    }

    public void registryBlockColors(RegisterColorHandlersEvent.Block event) {
        for (Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
            Block block = Finder.findBlock(entry.getKey());

            if (block instanceof LeavesBlock) {
                int color = entry.getValue();
                event.register((state, view, pos, tintIndex) -> color, block);
            }
        }
    }

    public void registryItemColors(RegisterColorHandlersEvent.Item event) {
        for (Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
            Block block = Finder.findBlock(entry.getKey());

            if (block instanceof LeavesBlock) {
                event.register((stack, tintIndex) -> {
                    if (!(stack.getItem() instanceof BlockItem blockItem)) {
                        return -1;
                    }

                    Block b = blockItem.getBlock();
                    return event.getBlockColors().getColor(
                        b.defaultBlockState(), null, null, tintIndex
                    );
                }, block);
            }
        }
    }

    public void registryBlockColorsAverage(RegisterColorHandlersEvent.Block event) {
        for (Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
            Block block = Finder.findBlock(entry.getKey());

            if (block instanceof LeavesBlock) {
                event.register((state, view, pos, tintIndex) ->
                    (view != null && pos != null)
                        ? BiomeColors.getAverageFoliageColor(view, pos)
                        : FoliageColor.get(0.5D, 1.0D),
                    block
                );
            }
        }
    }
}