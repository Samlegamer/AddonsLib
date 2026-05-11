package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.*;

public class TagsUtils
{
    public static TagKey<Item> getTagItem(String modidTagName)
    {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(modidTagName));
    }

    public static TagKey<Block> getTagBlock(String modidTagName)
    {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(modidTagName));
    }

    public static Map<Block, String> makeTags(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT, boolean isBlock)
    {
        Map<Block, String> result = new HashMap<>();
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            List<String> TagBlocks = isBlock ? blockId.tags().getTagsBlock() : blockId.tags().getTagsItem();
            for(String tagBlock : TagBlocks)
            {
                for (String mat : MAT)
                {
                    Block block = Finder.findBlock(modid, McwBlocksIdBase.replacement(blockId.id(), mat));

                    result.put(block, tagBlock);
                }
            }
        }
        return result;
    }

}