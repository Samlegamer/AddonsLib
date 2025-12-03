package fr.samlegamer.addonslib.client;

import fr.addonslib.api.client.McwColors;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.Map;

@Mod.EventBusSubscriber(modid = AddonsLib.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegistration
{
    @SubscribeEvent
    public static void registryBlockColors(ColorHandlerEvent.Block event) {
        for(Map.Entry<String, Integer> entry : McwColors.getNoColorLeaves().entrySet()) {
            String[] value = entry.getKey().split(":");
            Block block = Finder.findBlock(value[0], value[1]);
            event.getBlockColors().register((state, view, pos, tintIndex) -> entry.getValue(), block);
        }
    }

    @SubscribeEvent
    public static void registryItemColors(ColorHandlerEvent.Item event) {
        for(Map.Entry<String, Integer> entry : McwColors.getNoColorLeaves().entrySet()) {
            String[] value = entry.getKey().split(":");
            Block hedges = Finder.findBlock(value[0], value[1]);
            event.getItemColors().register((stack, tintIndex) -> {
                Block block = ((BlockItem) stack.getItem()).getBlock();
                return event.getBlockColors().getColor(block.defaultBlockState(), null, null, tintIndex);
            }, hedges);
        }
    }
}