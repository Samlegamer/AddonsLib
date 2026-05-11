package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.McwBlockIdBase;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import javax.annotation.Nullable;
import java.util.*;

public abstract class McwBlockTags extends BlockTagsProvider implements ITag
{
    public McwBlockTags(DataGenerator p_126511_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, modId, existingFileHelper);
    }

    @Override
    public void buildToTagSystem(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT)
    {
        Map<Block, String> tags = TagsUtils.makeTags(mcwBlockIdBase, modid, MAT, true);

        for(Map.Entry<Block, String> entry : tags.entrySet())
        {
            Block block = entry.getKey();
            String tag = entry.getValue();
            this.tag(TagsUtils.getTagBlock(tag)).add(block);
        }
    }
}