package fr.samlegamer.addonslib.registry;

import fr.addonslib.api.data.ModType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class McwProperties
{
    private static BlockBehaviour.Properties getBridgesWoodProperties()
    {
        return BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);
    }

    private static BlockBehaviour.Properties getBridgesStoneProperties()
    {
        return BlockBehaviour.Properties.copy(Blocks.ANDESITE);
    }

    private static BlockBehaviour.Properties getStairsWoodProperties()
    {
        return BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD);
    }

    private static BlockBehaviour.Properties getStairsStoneProperties()
    {
        return BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 2.3F).sound(SoundType.STONE);
    }

    private static BlockBehaviour.Properties getDoorsJapWoodProperties()
    {
        return BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).sound(SoundType.SCAFFOLDING);
    }

    private static BlockBehaviour.Properties getDoorsNormalWoodProperties()
    {
        return BlockBehaviour.Properties.copy(Blocks.OAK_DOOR);
    }

    private static BlockBehaviour.Properties getFencesNormalWoodProperties()
    {
        return BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);
    }

    private static BlockBehaviour.Properties getFencesCurvedWoodProperties()
    {
        return BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion();
    }

    private static BlockBehaviour.Properties getFencesStoneProperties()
    {
        return BlockBehaviour.Properties.copy(Blocks.ANDESITE);
    }

    private static BlockBehaviour.Properties getRoofsWoodProperties()
    {
        return BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD);
    }

    private static BlockBehaviour.Properties getRoofsStoneProperties()
    {
        return BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 3.0F).sound(SoundType.STONE).requiresCorrectToolForDrops();
    }

    private static BlockBehaviour.Properties getPathsWoodProperties()
    {
        return BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);
    }

    private static BlockBehaviour.Properties getWindowsWoodProperties()
    {
        return BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.6F, 1.2F);
    }

    private static BlockBehaviour.Properties getTrapdoorsWoodProperties()
    {
        return BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR);
    }

    private static BlockBehaviour.Properties getFurnituresWoodProperties()
    {
        return BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 2.3F);
    }

    public static BlockBehaviour.Properties getWoodProperties(String mat, ModType modType)
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
            default -> BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);
        };
    }

    public static BlockBehaviour.Properties getLeaveProperties()
    {
        return BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES);
    }

    public static BlockBehaviour.Properties getStoneProperties(ModType modType)
    {
        return switch (modType) {
            case BRIDGES -> getBridgesStoneProperties();
            case STAIRS -> getStairsStoneProperties();
            case FENCES -> getFencesStoneProperties();
            case ROOFS -> getRoofsStoneProperties();
            default -> BlockBehaviour.Properties.copy(Blocks.ANDESITE);
        };
    }
}