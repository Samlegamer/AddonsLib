package fr.addonslib.api.log;

import java.util.ArrayList;
import java.util.List;

public final class McwLogFilterList {
    public static final McwLogFilterList INSTANCE = new McwLogFilterList();

    private McwLogFilterList() {}

    public List<String> getList()
    {
        List<String> list = new ArrayList<>();
        list.add("Exception loading blockstate definition");
        list.add("Failed to load blockstate definition");
        list.add("Missing block model");
        list.add("Missing model for variant");
        list.add("Missing textures in model");
        list.add("Using missing texture, unable to load");
        list.add("Missing blockstate definition");
        list.add("Unable to load model");
        list.add("Unable to resolve texture reference");
        return list;
    }
}