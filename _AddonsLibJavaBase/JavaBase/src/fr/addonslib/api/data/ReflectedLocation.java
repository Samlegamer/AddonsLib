package fr.addonslib.api.data;

public class ReflectedLocation
{
    private final String forge;
    private final String fabric;

    public ReflectedLocation(String forge, String fabric)
    {
        this.forge = forge;
        this.fabric = fabric;
    }

    // Same
    public ReflectedLocation(String reflected)
    {
        this(reflected, reflected);
    }

    public String getForge()
    {
        return forge;
    }

    public String getFabric()
    {
        return fabric;
    }
}