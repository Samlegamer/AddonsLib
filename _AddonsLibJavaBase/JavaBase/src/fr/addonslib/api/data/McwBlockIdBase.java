package fr.addonslib.api.data;

import java.util.List;

public class McwBlockIdBase {
    private final String modid;
    private final List<BlockId> blocks;

    public McwBlockIdBase(String modid, List<BlockId> blocks) {
        this.modid = modid;
        this.blocks = blocks;
    }

    public String modid() {
        return modid;
    }

    public List<BlockId> blocks() {
        return blocks;
    }
}