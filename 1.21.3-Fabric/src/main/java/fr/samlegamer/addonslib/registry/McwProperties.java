package fr.samlegamer.addonslib.registry;

import fr.addonslib.api.data.ModType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;

public class McwProperties
{
    private static AbstractBlock.Settings getBridgesWoodProperties()
    {
        return AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);
    }

    private static AbstractBlock.Settings getBridgesStoneProperties()
    {
        return AbstractBlock.Settings.copy(Blocks.ANDESITE);
    }

    private static AbstractBlock.Settings getStairsWoodProperties()
    {
        return AbstractBlock.Settings.create().strength(2.0F, 2.3F).sounds(BlockSoundGroup.WOOD);
    }

    private static AbstractBlock.Settings getStairsStoneProperties()
    {
        return AbstractBlock.Settings.create().strength(2.0F, 2.3F).sounds(BlockSoundGroup.STONE);
    }

    private static AbstractBlock.Settings getDoorsJapWoodProperties()
    {
        return AbstractBlock.Settings.create().nonOpaque().strength(1.5F, 1.0F).sounds(BlockSoundGroup.SCAFFOLDING);
    }

    private static AbstractBlock.Settings getDoorsNormalWoodProperties()
    {
        return AbstractBlock.Settings.copy(Blocks.OAK_DOOR);
    }

    private static AbstractBlock.Settings getFencesNormalWoodProperties()
    {
        return AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);
    }

    private static AbstractBlock.Settings getFencesCurvedWoodProperties()
    {
        return AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque();
    }

    private static AbstractBlock.Settings getFencesStoneProperties()
    {
        return AbstractBlock.Settings.copy(Blocks.ANDESITE);
    }

    private static AbstractBlock.Settings getRoofsWoodProperties()
    {
        return AbstractBlock.Settings.create().strength(2.0F, 2.3F).sounds(BlockSoundGroup.WOOD);
    }

    private static AbstractBlock.Settings getRoofsStoneProperties()
    {
        return AbstractBlock.Settings.create().strength(1.5F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool();
    }

    private static AbstractBlock.Settings getPathsWoodProperties()
    {
        return AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);
    }

    private static AbstractBlock.Settings getWindowsWoodProperties()
    {
        return AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(0.6F, 1.2F);
    }

    private static AbstractBlock.Settings getTrapdoorsWoodProperties()
    {
        return AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR);
    }

    private static AbstractBlock.Settings getFurnituresWoodProperties()
    {
        return AbstractBlock.Settings.create().strength(2.0F, 2.3F);
    }

    public static AbstractBlock.Settings getWoodProperties(String mat, ModType modType)
    {
        return switch (modType) {
            case BRIDGES -> getBridgesWoodProperties();
            case STAIRS -> getStairsWoodProperties();
            case DOORS -> {
                if (mat.contains("japanese")) {
                    yield getDoorsJapWoodProperties();
                }
                yield getDoorsNormalWoodProperties();
            }
            case FENCES -> {
                if (mat.contains("curved_gate")) {
                    yield getFencesCurvedWoodProperties();
                }
                yield getFencesNormalWoodProperties();
            }
            case ROOFS -> getRoofsWoodProperties();
            case PATHS -> getPathsWoodProperties();
            case WINDOWS -> getWindowsWoodProperties();
            case TRAPDOORS -> getTrapdoorsWoodProperties();
            case FURNITURES -> getFurnituresWoodProperties();
            default -> AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);
        };
    }

    public static AbstractBlock.Settings getLeaveProperties()
    {
        return AbstractBlock.Settings.copy(Blocks.OAK_LEAVES);
    }

    public static AbstractBlock.Settings getStoneProperties(ModType modType)
    {
        return switch (modType) {
            case BRIDGES -> getBridgesStoneProperties();
            case STAIRS -> getStairsStoneProperties();
            case FENCES -> getFencesStoneProperties();
            case ROOFS -> getRoofsStoneProperties();
            default -> AbstractBlock.Settings.copy(Blocks.ANDESITE);
        };
    }
}