package fr.samlegamer.addonslib.generation.recipes.mat;

import net.minecraft.block.Block;

public class McwWoodMat
{
    private final Block log;
    private final Block planks;
    private final Block strippedLog;
    private final Block slab;
    private final Block fence;
    private final Block trapdoor;

    public McwWoodMat(Block log, Block planks, Block strippedLog, Block slab, Block fence, Block trapdoor)
    {
        this.log = log;
        this.planks = planks;
        this.strippedLog = strippedLog;
        this.slab = slab;
        this.fence = fence;
        this.trapdoor = trapdoor;
    }

    public Block getLog()
    {
        return log;
    }

    public Block getPlanks()
    {
        return planks;
    }

    public Block getStrippedLog()
    {
        return strippedLog;
    }

    public Block getSlab()
    {
        return slab;
    }

    public Block getFence()
    {
        return fence;
    }

    public Block getTrapdoor()
    {
        return trapdoor;
    }
}