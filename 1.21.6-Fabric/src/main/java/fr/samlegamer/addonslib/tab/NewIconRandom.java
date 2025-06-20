package fr.samlegamer.addonslib.tab;

import java.util.EnumSet;
import java.util.Random;
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
        private final Block roofsIcon, fencesIcon, furnituresIcon, bridgesIcon, windowsIcon, doorsIcon, trapdoorsIcon, pathsIcon, stairsIcon;
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
}