package fr.addonslib.api.recipes.material;

public class McwStoneMat<T>
{
    private final T stoneBase;
    private final T wall;
    private final T slab;
    private final T smoothStone;

    public McwStoneMat(T stoneBase, T wall, T slab, T smoothStone)
    {
        this.stoneBase = stoneBase;
        this.wall = wall;
        this.slab = slab;
        this.smoothStone = smoothStone;
    }

    public T getStoneBase()
    {
        return stoneBase;
    }

    public T getWall()
    {
        return wall;
    }

    public T getSlab()
    {
        return slab;
    }

    public T getSmoothStone()
    {
        return smoothStone;
    }
}
