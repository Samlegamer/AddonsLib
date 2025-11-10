package fr.samlegamer.addonslib.generation.recipes.mat;

import net.minecraft.world.level.block.Block;

public class McwStoneMat
{
    private final Block stoneBase;
    private final Block wall;
    private final Block slab;
    private final Block smoothStone;

    public McwStoneMat(Block stoneBase, Block wall, Block slab, Block smoothStone)
    {
        this.stoneBase = stoneBase;
        this.wall = wall;
        this.slab = slab;
        this.smoothStone = smoothStone;
    }

    public Block getStoneBase()
    {
        return stoneBase;
    }

    public Block getWall()
    {
        return wall;
    }

    public Block getSlab()
    {
        return slab;
    }

    public Block getSmoothStone()
    {
        return smoothStone;
    }
}
