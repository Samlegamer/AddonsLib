package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;

import java.util.List;

public interface ITag
{
    void buildToTagSystem(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT);

    default void addAllMcwTagsWood(String modid, List<String> WOOD, ModType... types)
    {
        for(ModType type : types)
        {
            McwBlockIdBase mcwWoodMat = McwBlocksIdBase.getBlocksWithModidWood(type);
            buildToTagSystem(mcwWoodMat, modid, WOOD);
        }
    }

    default void addAllMcwTagsLeave(String modid, List<String> WOOD)
    {
        McwBlockIdBase mcwWoodMat = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        buildToTagSystem(mcwWoodMat, modid, WOOD);
    }

    default void addAllMcwTagsStone(String modid, List<String> STONE, ModType... types)
    {
        for(ModType type : types)
        {
            McwBlockIdBase mcwWoodMat = McwBlocksIdBase.getBlocksWithModidStone(type);
            buildToTagSystem(mcwWoodMat, modid, STONE);
        }
    }
}