package fr.addonslib.api.obj;

public class DoubleObject<T, U>
{
    private final T t;
    private final U u;

    public DoubleObject(T t, U u)
    {
        this.t = t;
        this.u = u;
    }

    public T getFirst()
    {
        return t;
    }

    public U getSecond()
    {
        return u;
    }
}
