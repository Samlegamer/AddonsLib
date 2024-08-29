package fr.samlegamer.addonslib.client;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(value = Dist.CLIENT)
public class ColorRegistry
{
	private String MODID;
	private List<String> NoColorLeaves = new ArrayList<String>();
	
	public ColorRegistry(String MODID, List<String> LEAVES)
	{
		this.MODID = MODID;
		this.NoColorLeaves = LEAVES;
	}
	
	@OnlyIn(value = Dist.CLIENT)
	public void colorsBlock(ColorHandlerEvent.Block event)
	{
		for(String i : NoColorLeaves)
		{
			Block hedges = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(this.MODID, i+"_hedge"));
			event.getBlockColors().register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getAverageFoliageColor(view, pos) : FoliageColors.get(0.5D, 1.0D), hedges);
		}
	}
	
	@OnlyIn(value = Dist.CLIENT)
	public void colorsItem(ColorHandlerEvent.Item event)
	{
		for(String i : NoColorLeaves)
		{
			Block hedges = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(this.MODID, i+"_hedge"));
			event.getItemColors().register((stack, tintIndex) -> {
	            Block block = ((BlockItem) stack.getItem()).getBlock();
	            return event.getBlockColors().getColor(block.defaultBlockState(), null, null, tintIndex);
	        }, hedges);
		}
	}

	public List<String> getNoColorLeaves()
	{
		return this.NoColorLeaves;
	}
}