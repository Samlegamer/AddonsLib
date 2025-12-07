package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import javax.annotation.Nullable;
import java.util.*;

public abstract class McwBlockTags extends BlockTagsProvider
{
    public McwBlockTags(DataGenerator p_126511_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, modId, existingFileHelper);
    }

    private void makeTags(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT)
    {
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            for(String tagBlock : blockId.tags().getTagsBlock())
            {
                for (String mat : MAT)
                {
                    Block result = Finder.findBlock(modid, McwBlocksIdBase.replacement(blockId.id(), mat));

                    this.tag(getTag(tagBlock)).add(result);
                }
            }
        }
    }

    public void addAllMcwTagsWood(String modid, List<String> WOOD, ModType... types)
    {
        for(ModType type : types)
        {
            McwBlockIdBase mcwWoodMat = McwBlocksIdBase.getBlocksWithModidWood(type);
            makeTags(mcwWoodMat, modid, WOOD);
        }
    }

    public void addAllMcwTagsLeave(String modid, List<String> WOOD)
    {
        McwBlockIdBase mcwWoodMat = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        makeTags(mcwWoodMat, modid, WOOD);
    }

    public void addAllMcwTagsStone(String modid, List<String> STONE, ModType... types)
    {
        for(ModType type : types)
        {
            McwBlockIdBase mcwWoodMat = McwBlocksIdBase.getBlocksWithModidStone(type);
            makeTags(mcwWoodMat, modid, STONE);
        }
    }

    public static ITag.INamedTag<Block> getTag(String modidTagName)
    {
        return BlockTags.createOptional(new ResourceLocation(modidTagName));
    }
}