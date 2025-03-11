package fr.samlegamer.addonslib.tab;

import java.util.EnumSet;
import java.util.Random;

import fr.samlegamer.addonslib.AddonsLib;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class NewIconRandom
{
	public enum BlockType {
        ROOFS, FENCES, BRIDGES, FURNITURES, WINDOWS, DOORS, TRAPDOORS, PATHS, STAIRS
    }

    public static class NewProperties {
        private EnumSet<BlockType> activeTypes = EnumSet.noneOf(BlockType.class);
        private Block roofsIcon, fencesIcon, furnituresIcon, bridgesIcon, windowsIcon, doorsIcon, trapdoorsIcon, pathsIcon, stairsIcon;
        private int dependencies = 0;
        public Block defaultIcon = Blocks.CRAFTING_TABLE;

        public NewProperties(Block roofsIcon, Block fencesIcon, Block furnituresIcon, Block bridgesIcon, Block windowsIcon, Block doorsIcon, Block trapdoorsIcon, Block pathsIcon, Block stairsIcon) {
            this.roofsIcon = roofsIcon;
            this.fencesIcon = fencesIcon;
            this.furnituresIcon = furnituresIcon;
            this.bridgesIcon = bridgesIcon;
            this.windowsIcon = windowsIcon;
            this.doorsIcon = doorsIcon;
            this.trapdoorsIcon = trapdoorsIcon;
            this.pathsIcon = pathsIcon;
            this.stairsIcon = stairsIcon;
        }

        public NewProperties addType(BlockType type) {
            activeTypes.add(type);
            return this;
        }

        public Block buildIcon(BlockType... types) {
            for (BlockType type : types) {
                if (isTypeLoaded(type)) {
                    dependencies++;
                }
            }

            if (allTypesLoaded(types)) {
                return getRandomIcon(types);
            } else {
                return getFallbackIcon(types);
            }
        }

        private Block getRandomIcon(BlockType... types) {
            Random rand = new Random();
            int i = rand.nextInt(dependencies);
            switch (types[i]) {
                case BRIDGES: return bridgesIcon;
                case FENCES: return fencesIcon;
                case ROOFS: return roofsIcon;
                case FURNITURES: return furnituresIcon;
                case PATHS: return pathsIcon;
                case TRAPDOORS: return trapdoorsIcon;
                case DOORS: return doorsIcon;
                case WINDOWS: return windowsIcon;
                case STAIRS: return stairsIcon;
                default: return defaultIcon;
            }
        }

        private boolean isTypeLoaded(BlockType type) {
            String modId = getModIdForType(type);
            return FabricLoader.getInstance().isModLoaded(modId);
        }

        private boolean allTypesLoaded(BlockType... types) {
            for (BlockType type : types) {
                if (!isTypeLoaded(type)) return false;
            }
            return true;
        }

        private String getModIdForType(BlockType type) {
            switch (type) {
                case ROOFS: return "mcwroofs";
                case FENCES: return "mcwfences";
                case BRIDGES: return "mcwbridges";
                case FURNITURES: return "mcwfurnitures";
                case WINDOWS: return "mcwwindows";
                case DOORS: return "mcwdoors";
                case TRAPDOORS: return "mcwtrpdoors";
                case PATHS: return "mcwpaths";
                case STAIRS: return "mcwstairs";
                default: return "";
            }
        }

        private Block getFallbackIcon(BlockType... types) {
            for (BlockType type : types) {
                if (isTypeLoaded(type)) {
                    return getIconForType(type);
                }
            }
            return defaultIcon;
        }

        private Block getIconForType(BlockType type) {
            switch (type) {
                case ROOFS: return roofsIcon;
                case FENCES: return fencesIcon;
                case BRIDGES: return bridgesIcon;
                case FURNITURES: return furnituresIcon;
                case WINDOWS: return windowsIcon;
                case DOORS: return doorsIcon;
                case TRAPDOORS: return trapdoorsIcon;
                case PATHS: return pathsIcon;
                case STAIRS: return stairsIcon;
                default: return defaultIcon;
            }
        }
    }
	
	public static class Properties
	{
		private boolean roofs = false;
		private boolean fences = false;
		private boolean bridges = false;
		private boolean furnitures = false;
		private boolean windows = false;
		private boolean doors = false;
		private boolean trapdoors = false;
		private boolean paths = false;
		private boolean stairs = false;
		private Block roofsIcon, fencesIcon, furnituresIcon, bridgesIcon, windowsIcon, doorsIcon, trapdoorsIcon, pathsIcon, stairsIcon;
		private int depedencies = 0;

		/**
		 * Is For Wood Compat ex:Macaw's BOP
		 * Parameter : (roofsIcon, fencesIcon, furnituresIcon, bridgesIcon, windowsIcon, doorsIcon, trapdoorsIcon, pathsIcon)
		 * Use Finder.findBlock(String MODID, String nameBlock); for set blocks
		 */
		public Properties(Block roofsIcon, Block fencesIcon, Block furnituresIcon, Block bridgesIcon, 
		Block windowsIcon, Block doorsIcon, Block trapdoorsIcon, Block pathsIcon, Block stairsIcon)
		{
			this.roofsIcon = roofsIcon;
			this.fencesIcon = fencesIcon;
			this.furnituresIcon = furnituresIcon;
			this.bridgesIcon = bridgesIcon;
			this.windowsIcon = windowsIcon;
			this.doorsIcon = doorsIcon;
			this.trapdoorsIcon = trapdoorsIcon;
			this.pathsIcon = pathsIcon;
			this.stairsIcon = stairsIcon;
		}

		/*
		 * Use new Parameter with stairsIcon
		 */
		@Deprecated
		public Properties(Block roofsIcon, Block fencesIcon, Block furnituresIcon, Block bridgesIcon, 
		Block windowsIcon, Block doorsIcon, Block trapdoorsIcon, Block pathsIcon)
		{
			this(roofsIcon, fencesIcon, furnituresIcon, bridgesIcon, windowsIcon, doorsIcon, trapdoorsIcon, pathsIcon, Blocks.CRAFTING_TABLE);
		}
		
		/**
		 * Is For Stone Compat ex:Macaw's Quark
		 * Parameter : (roofsIcon, fencesIcon, bridgesIcon)
		 */
		public Properties(Block roofsIcon, Block fencesIcon, Block bridgesIcon)
		{
			this.roofsIcon = roofsIcon;
			this.fencesIcon = fencesIcon;
			this.bridgesIcon = bridgesIcon;
		}
		
		public Properties stairs()
		{
			stairs=true;
			return this;
		}
		
		public Properties windows()
		{
			windows=true;
			return this;
		}
		
		public Properties doors()
		{
			doors=true;
			return this;
		}
		
		public Properties trapdoors()
		{
			trapdoors=true;
			return this;
		}
		
		public Properties paths()
		{
			paths=true;
			return this;
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
		
		public Block buildWood()
		{
			loadedBool(bridges);
			loadedBool(fences);
			loadedBool(roofs);
			loadedBool(furnitures);
			loadedBool(paths);
			loadedBool(trapdoors);
			loadedBool(doors);
			loadedBool(windows);
			loadedBool(stairs);
			if(loadedAllWood())
			{
				Random rand = new Random();
	    		int i = rand.nextInt(depedencies - 1);
	    		switch (i) {
				case 1:
		    		return bridgesIcon;
				case 2:
		    		return fencesIcon;
				case 0:
		    		return roofsIcon;
				case 3:
		    		return furnituresIcon;
				case 4:
		    		return pathsIcon;
				case 5:
		    		return trapdoorsIcon;
				case 6:
		    		return doorsIcon;
				case 7:
		    		return windowsIcon;
				case 8:
		    		return stairsIcon;
				default:
					break;
				}
			}
			else
			{
				if(loaded("mcwfurnitures"))
				{
					return furnituresIcon;
				}
				else if(loaded("mcwbridges"))
				{
					return bridgesIcon;
				}
				else if(loaded("mcwfences"))
				{
					return fencesIcon;
				}
				else if(loaded("mcwroofs"))
				{
					return roofsIcon;
				}
				else if(loaded("mcwpaths"))
				{
					return pathsIcon;
				}
				else if(loaded("mcwdoors"))
				{
					return doorsIcon;
				}
				else if(loaded("mcwtrpdoors"))
				{
					return trapdoorsIcon;
				}
				else if(loaded("mcwwindows"))
				{
					return windowsIcon;
				}
				else if(loaded("mcwstairs"))
				{
					return stairsIcon;
				}
			}
			return Blocks.CRAFTING_TABLE;
		}
		
		public Block buildStone()
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
		    		return bridgesIcon;
				case 2:
		    		return fencesIcon;
				case 0:
		    		return roofsIcon;
				default:
					break;
				}
			}
			else
			{
				if(loaded("mcwbridges"))
				{
					return bridgesIcon;
				}
				else if(loaded("mcwfences"))
				{
					return fencesIcon;
				}
				else if(loaded("mcwroofs"))
				{
					return roofsIcon;
				}
			}
			return Blocks.CRAFTING_TABLE;
		}
				
		private void loadedBool(boolean b)
		{
			if(b) { this.depedencies=this.depedencies+1; }
		}
		
		private boolean loaded(String modid)
	    {
	    	return AddonsLib.isLoaded(modid);
	    }
		
	    private boolean loadedAllStone()
	    {
	    	return loaded("mcwbridges") && loaded("mcwfences") && loaded("mcwroofs");
	    }

	    
	    private boolean loadedAllWood()
	    {
	    	return loaded("mcwbridges") && loaded("mcwfences") && loaded("mcwroofs") && loaded("mcwfurnitures") && loaded("mcwpaths") && loaded("mcwdoors") && loaded("mcwtrpdoors") && loaded("mcwwindows");
	    }
	}
}