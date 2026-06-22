package fr.samlegamer.addonslib.client;

import fr.addonslib.api.client.McwColors;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ColorRegistry
{
    private final McwColors mcwColors;

    public ColorRegistry(McwColors mcwColors)
    {
        this.mcwColors = mcwColors;
    }

    public void registryBlockColors(RegisterColorHandlersEvent.Block event) {
        for(Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
            String value = entry.getKey();
            Block block = Finder.findBlock(value);
            event.getBlockColors().register((state, view, pos, tintIndex) -> entry.getValue(), block);
        }
    }

    public void registryItemColors(RegisterColorHandlersEvent.Item event) {
        for(Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
            String value = entry.getKey();
            Block hedges = Finder.findBlock(value);
            event.getItemColors().register((stack, tintIndex) -> {
                Block block = ((BlockItem) stack.getItem()).getBlock();
                return event.getBlockColors().getColor(block.defaultBlockState(), null, null, tintIndex);
            }, hedges);
        }
    }

    public void registryBlockColorsAverage(RegisterColorHandlersEvent.Block event) {
        for(Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
            String value = entry.getKey();
            Block block = Finder.findBlock(value);
            event.getBlockColors().register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getAverageFoliageColor(view, pos) : FoliageColor.get(0.5D, 1.0D), block);
        }
    }
}