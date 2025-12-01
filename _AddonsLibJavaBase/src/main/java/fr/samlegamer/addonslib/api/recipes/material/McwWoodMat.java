package fr.addonslib.api.recipes.material;

public class McwWoodMat<T>
{
    private final T log;
    private final T planks;
    private final T strippedLog;
    private final T slab;
    private final T fence;
    private final T trapdoor;

    public McwWoodMat(T log, T planks, T strippedLog, T slab, T fence, T trapdoor)
    {
        this.log = log;
        this.planks = planks;
        this.strippedLog = strippedLog;
        this.slab = slab;
        this.fence = fence;
        this.trapdoor = trapdoor;
    }

    public T getLog()
    {
        return log;
    }

    public T getPlanks()
    {
        return planks;
    }

    public T getStrippedLog()
    {
        return strippedLog;
    }

    public T getSlab()
    {
        return slab;
    }

    public T getFence()
    {
        return fence;
    }

    public T getTrapdoor()
    {
        return trapdoor;
    }
}