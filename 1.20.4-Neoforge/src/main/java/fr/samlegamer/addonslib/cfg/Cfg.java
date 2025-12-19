package fr.samlegamer.addonslib.cfg;


import net.neoforged.neoforge.common.ModConfigSpec;

public class Cfg
{
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue filterLogs;

    static {
        BUILDER.push("AddonsLib Config !");

        filterLogs = BUILDER
                .comment("Filter the logs error for blockstate and model")
                .define("Define log filter", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
