package fr.samlegamer.addonslib.tab;

import java.util.Random;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;

/*
 * For randomize icon item
 */
public class IconRandom
{
	public static class Properties
	{
		private boolean roofs = false;
		private boolean fences = false;
		private boolean bridges = false;
		private boolean furnitures = false;
		private RegistryObject<Item> roofsIcon, fencesIcon, furnituresIcon, bridgesIcon;
		private int depedencies = 0;

		/*
		 * Is For Wood Compat ex:Macaw's BOP
		 * Parameter : (roofsIcon, fencesIcon, furnituresIcon, bridgesIcon)
		 */
		public Properties(RegistryObject<Item> roofsIcon, RegistryObject<Item> fencesIcon, RegistryObject<Item> furnituresIcon, RegistryObject<Item> bridgesIcon)
		{
			this.roofsIcon = roofsIcon;
			this.fencesIcon = fencesIcon;
			this.furnituresIcon = furnituresIcon;
			this.bridgesIcon = bridgesIcon;
		}
		
		/*
		 * Is For Stone Compat ex:Macaw's Quark
		 * Parameter : (roofsIcon, fencesIcon, bridgesIcon)
		 */
		public Properties(RegistryObject<Item> roofsIcon, RegistryObject<Item> fencesIcon, RegistryObject<Item> bridgesIcon)
		{
			this.roofsIcon = roofsIcon;
			this.fencesIcon = fencesIcon;
			this.bridgesIcon = bridgesIcon;
		}
		
		public Properties roofs()
		{
			roofs=true;
			return this;
		}
		
		public Properties fences()
		{
			fences=true;
			return this;
		}

		public Properties bridges()
		{
			bridges=true;
			return this;
		}
		
		public Properties furnitures()
		{
			furnitures=true;
			return this;
		}
		
		public Item buildWood()
		{
			loadedBool(bridges);
			loadedBool(fences);
			loadedBool(roofs);
			loadedBool(furnitures);
			if(loadedAllWood())
			{
				Random rand = new Random();
	    		int i = rand.nextInt(depedencies - 1);
	    		switch (i) {
				case 1:
		    		return bridgesIcon.get();
				case 2:
		    		return fencesIcon.get();
				case 0:
		    		return roofsIcon.get();
				case 3:
		    		return furnituresIcon.get();
				default:
					break;
				}
			}
			else
			{
				if(loaded("mcwfurnitures"))
				{
					return furnituresIcon.get();
				}
				else if(loaded("mcwbridges"))
				{
					return bridgesIcon.get();
				}
				else if(loaded("mcwfences"))
				{
					return fencesIcon.get();
				}
				else if(loaded("mcwroofs"))
				{
					return roofsIcon.get();
				}
			}
			return Blocks.CRAFTING_TABLE.asItem();
		}
		
		public Item buildStone()
		{
			loadedBool(bridges);
			loadedBool(fences);
			loadedBool(roofs);
			if(loadedAllStone())
			{
				Random rand = new Random();
	    		int i = rand.nextInt(depedencies - 1);
	    		switch (i) {
				case 1:
		    		return bridgesIcon.get();
				case 2:
		    		return fencesIcon.get();
				case 0:
		    		return roofsIcon.get();
				default:
					break;
				}
			}
			else
			{
				if(loaded("mcwbridges"))
				{
					return bridgesIcon.get();
				}
				else if(loaded("mcwfences"))
				{
					return fencesIcon.get();
				}
				else if(loaded("mcwroofs"))
				{
					return roofsIcon.get();
				}
			}
			return Blocks.CRAFTING_TABLE.asItem();
		}
				
		private void loadedBool(boolean b)
		{
			if(b) { this.depedencies=this.depedencies+1; }
		}
		
		private boolean loaded(String modid)
	    {
	    	return ModList.get().isLoaded(modid);
	    }
		
	    private boolean loadedAllStone()
	    {
	    	return loaded("mcwbridges") && loaded("mcwfences") && loaded("mcwroofs");
	    }

	    
	    private boolean loadedAllWood()
	    {
	    	return loaded("mcwbridges") && loaded("mcwfences") && loaded("mcwroofs") && loaded("mcwfurnitures");
	    }
	}
}