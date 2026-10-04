package fr.samlegamer.addonslib.cfg;

import net.minecraftforge.common.ForgeConfigSpec;

public class Cfg
{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue filterLogs;

    static {
        BUILDER.push("AddonsLib Config !");

        filterLogs = BUILDER
                .comment("Filter the logs error for blockstate and model")
                .define("Define log filter", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
