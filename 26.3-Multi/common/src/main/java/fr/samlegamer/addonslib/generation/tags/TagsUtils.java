package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.obj.DoubleObject;
import net.minecraft.resources.Identifier;
import java.util.*;

public class TagsUtils
{
    public static Map<DoubleObject<String, String>, String> makeTags(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT, boolean isBlock)
    {
        Map<DoubleObject<String, String>, String> result = new HashMap<>();
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            List<String> TagBlocks = isBlock ? blockId.tags().getTagsBlock() : blockId.tags().getTagsItem();
            for(String tagBlock : TagBlocks)
            {
                for (String mat : MAT)
                {
                    DoubleObject<String, String> block = new DoubleObject<>(modid, McwBlocksIdBase.replacement(blockId.id(), mat));
                    result.put(block, tagBlock);
                }
            }
        }
        return result;
    }

    public static Identifier parseResourceLocation(String resourceLocationString)
    {
        return Identifier.parse(resourceLocationString);
    }
}