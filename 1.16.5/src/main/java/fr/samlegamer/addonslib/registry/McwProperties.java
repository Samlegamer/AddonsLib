package fr.samlegamer.addonslib.registry;

import fr.addonslib.api.data.ModType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class McwProperties
{
    private static AbstractBlock.Properties getBridgesWoodProperties()
    {
        return AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);
    }

    private static AbstractBlock.Properties getBridgesStoneProperties()
    {
        return AbstractBlock.Properties.copy(Blocks.ANDESITE);
    }

    private static AbstractBlock.Properties getStairsWoodProperties()
    {
        return AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 2.3F).harvestTool(ToolType.AXE).sound(SoundType.WOOD);
    }

    private static AbstractBlock.Properties getStairsStoneProperties()
    {
        return AbstractBlock.Properties.of(Material.STONE).strength(2.0F, 2.3F).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE);
    }

    private static AbstractBlock.Properties getDoorsJapWoodProperties()
    {
        return AbstractBlock.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).harvestTool(ToolType.AXE).sound(SoundType.SCAFFOLDING);
    }

    private static AbstractBlock.Properties getDoorsNormalWoodProperties()
    {
        return AbstractBlock.Properties.copy(Blocks.OAK_DOOR);
    }

    private static AbstractBlock.Properties getFencesNormalWoodProperties()
    {
        return AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);
    }

    private static AbstractBlock.Properties getFencesCurvedWoodProperties()
    {
        return AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE).noOcclusion();
    }

    private static AbstractBlock.Properties getFencesStoneProperties()
    {
        return AbstractBlock.Properties.copy(Blocks.ANDESITE);
    }

    private static AbstractBlock.Properties getRoofsWoodProperties()
    {
        return AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD).harvestTool(ToolType.AXE);
    }

    private static AbstractBlock.Properties getRoofsStoneProperties()
    {
        return AbstractBlock.Properties.of(Material.STONE).strength(1.5F, 3.0F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops();
    }

    private static AbstractBlock.Properties getPathsWoodProperties()
    {
        return AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);
    }

    private static AbstractBlock.Properties getWindowsWoodProperties()
    {
        return AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.6F, 1.2F).harvestTool(ToolType.AXE);
    }

    private static AbstractBlock.Properties getTrapdoorsWoodProperties()
    {
        return AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR);
    }

    private static AbstractBlock.Properties getFurnituresWoodProperties()
    {
        return AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 2.3F).harvestTool(ToolType.AXE);
    }

    public static AbstractBlock.Properties getWoodProperties(String mat, ModType modType)
    {
        switch (modType) {
            case BRIDGES:
                return getBridgesWoodProperties();
            case STAIRS:
                return getStairsWoodProperties();
            case DOORS:
                if(mat.contains("japanese"))
                {
                    return getDoorsJapWoodProperties();
                }
                return getDoorsNormalWoodProperties();
            case FENCES:
                if(mat.contains("curved_gate"))
                {
                    return getFencesCurvedWoodProperties();
                }
                return getFencesNormalWoodProperties();
            case ROOFS:
                return getRoofsWoodProperties();
            case PATHS:
                return getPathsWoodProperties();
            case WINDOWS:
                return getWindowsWoodProperties();
            case TRAPDOORS:
                return getTrapdoorsWoodProperties();
            case FURNITURES:
                return getFurnituresWoodProperties();
            default:
                return AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);
        }
    }

    public static AbstractBlock.Properties getLeaveProperties()
    {
        return AbstractBlock.Properties.copy(Blocks.OAK_LEAVES).harvestTool(ToolType.HOE);
    }

    public static AbstractBlock.Properties getStoneProperties(ModType modType)
    {
        switch (modType) {
            case BRIDGES:
                return getBridgesStoneProperties();
            case STAIRS:
                return getStairsStoneProperties();
            case FENCES:
                return getFencesStoneProperties();
            case ROOFS:
                return getRoofsStoneProperties();
            default:
                return AbstractBlock.Properties.copy(Blocks.ANDESITE);
        }
    }
}