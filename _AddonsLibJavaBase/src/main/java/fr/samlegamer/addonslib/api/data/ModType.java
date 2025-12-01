package fr.addonslib.api.data;

public enum ModType {
    ROOFS("mcwroofs"), FENCES("mcwfences"), BRIDGES("mcwbridges"), FURNITURES("mcwfurnitures"),
    WINDOWS("mcwwindows"), DOORS("mcwdoors"), TRAPDOORS("mcwtrpdoors"),
    PATHS("mcwpaths"), STAIRS("mcwstairs");

    private final String modid;

    ModType(String modid)
    {
        this.modid = modid;
    }

    public final String getModid()
    {
        return this.modid;
    }
}