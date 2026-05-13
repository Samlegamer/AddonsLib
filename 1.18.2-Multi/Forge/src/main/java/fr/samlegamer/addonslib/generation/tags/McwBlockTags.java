package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.ModType;
import fr.addonslib.api.obj.DoubleObject;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import javax.annotation.Nullable;
import java.util.*;

public abstract class McwBlockTags extends BlockTagsProvider implements ITag
{
    public McwBlockTags(DataGenerator p_126511_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, modId, existingFileHelper);
    }

//    private void makeTags(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT)
//    {
//        for(BlockId blockId : mcwBlockIdBase.blocks())
//        {
//            for(String tagBlock : blockId.tags().getTagsBlock())
//            {
//                for (String mat : MAT)
//                {
//                    Block result = Finder.findBlock(modid, McwBlocksIdBase.replacement(blockId.id(), mat));
//
//                    this.tag(getTag(tagBlock)).add(result);
//                }
//            }
//        }
//    }
//
//    public void addAllMcwTagsWood(String modid, List<String> WOOD, ModType... types)
//    {
//        for(ModType type : types)
//        {
//            McwBlockIdBase mcwWoodMat = McwBlocksIdBase.getBlocksWithModidWood(type);
//            makeTags(mcwWoodMat, modid, WOOD);
//        }
//    }
//
//    public void addAllMcwTagsLeave(String modid, List<String> WOOD)
//    {
//        McwBlockIdBase mcwWoodMat = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
//        makeTags(mcwWoodMat, modid, WOOD);
//    }
//
//    public void addAllMcwTagsStone(String modid, List<String> STONE, ModType... types)
//    {
//        for(ModType type : types)
//        {
//            McwBlockIdBase mcwWoodMat = McwBlocksIdBase.getBlocksWithModidStone(type);
//            makeTags(mcwWoodMat, modid, STONE);
//        }
//    }
//
//    public static TagKey<Block> getTag(String modidTagName)
//    {
//        return BlockTags.create(ResourceLocation.parse(modidTagName));
//    }

    @Override
    public void buildToTagSystem(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT)
    {
        Map<DoubleObject<String, String>, String> tags = TagsUtils.makeTags(mcwBlockIdBase, modid, MAT, true);

        for(Map.Entry<DoubleObject<String, String>, String> entry : tags.entrySet())
        {
            Block block = Finder.findBlock(entry.getKey().getFirst(), entry.getKey().getSecond());
            String tagName = entry.getValue();

            if(tagName != null && !tagName.isEmpty() && block != Blocks.AIR)
            {
                this.tag(getTag(tagName)).add(block);
            }
        }
    }

    @Override
    public void addAllMcwTagsWood(String modid, List<String> WOOD, ModType... types) {
        ITag.super.addAllMcwTagsWood(modid, WOOD, types);
    }

    @Override
    public void addAllMcwTagsLeave(String modid, List<String> WOOD) {
        ITag.super.addAllMcwTagsLeave(modid, WOOD);
    }

    @Override
    public void addAllMcwTagsStone(String modid, List<String> STONE, ModType... types) {
        ITag.super.addAllMcwTagsStone(modid, STONE, types);
    }

    public static TagKey<Block> getTag(String modidTagName)
    {
        return BlockTags.create(TagsUtils.parseResourceLocation(modidTagName));
    }
}