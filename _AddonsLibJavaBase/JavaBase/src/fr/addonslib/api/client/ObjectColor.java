package fr.addonslib.api.client;

public class ObjectColor
{
    private final String MODID;
    private final String name;
    private final int color;
    public static final int DEFAULT_COLOR = -12012264;

    public ObjectColor(String MODID, String name, int color) {
        this.MODID = MODID;
        this.name = name;
        this.color = color;
    }

    public ObjectColor(String MODID, String name) {
        this(MODID, name, -12012264);
    }

    public String getMODID() {
        return MODID;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }
}