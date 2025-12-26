package fr.samlegamer.addonslib.tab;

import java.util.EnumSet;
import java.util.Random;

import fr.addonslib.api.data.ModType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.ModList;

public class NewIconRandom
{
	public static class NewProperties {
        private final EnumSet<ModType> activeTypes = EnumSet.noneOf(ModType.class);
        private final Block roofsIcon, fencesIcon, furnituresIcon, bridgesIcon, windowsIcon, doorsIcon, trapdoorsIcon, pathsIcon, stairsIcon;
        private int dependencies = 0;
        public Block defaultIcon = Blocks.CRAFTING_TABLE;

        public NewProperties(Block roofsIcon, Block fencesIcon, Block furnituresIcon, Block bridgesIcon, Block windowsIcon, Block doorsIcon, Block trapdoorsIcon, Block pathsIcon, Block stairsIcon) {
            this.bridgesIcon = bridgesIcon;
            this.roofsIcon = roofsIcon;
            this.fencesIcon = fencesIcon;
            this.furnituresIcon = furnituresIcon;
            this.windowsIcon = windowsIcon;
            this.doorsIcon = doorsIcon;
            this.trapdoorsIcon = trapdoorsIcon;
            this.pathsIcon = pathsIcon;
            this.stairsIcon = stairsIcon;
        }

        public NewProperties addType(ModType type) {
            activeTypes.add(type);
            return this;
        }

        public Block buildIcon(ModType... types) {
            for (ModType type : types) {
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

        private Block getRandomIcon(ModType... types) {
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

        private boolean isTypeLoaded(ModType type) {
            String modId = getModIdForType(type);
            return ModList.get().isLoaded(modId);
        }

        private boolean allTypesLoaded(ModType... types) {
            for (ModType type : types) {
                if (!isTypeLoaded(type)) return false;
            }
            return true;
        }

        private String getModIdForType(ModType type) {
            switch (type) {
                case ROOFS: return ModType.ROOFS.getModid();
                case FENCES: return ModType.FENCES.getModid();
                case BRIDGES: return ModType.BRIDGES.getModid();
                case FURNITURES: return ModType.FURNITURES.getModid();
                case WINDOWS: return ModType.WINDOWS.getModid();
                case DOORS: return ModType.DOORS.getModid();
                case TRAPDOORS: return ModType.TRAPDOORS.getModid();
                case PATHS: return ModType.PATHS.getModid();
                case STAIRS: return ModType.STAIRS.getModid();
                default: return "";
            }
        }

        private Block getFallbackIcon(ModType... types) {
            for (ModType type : types) {
                if (isTypeLoaded(type)) {
                    return getIconForType(type);
                }
            }
            return defaultIcon;
        }

        private Block getIconForType(ModType type) {
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