package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.McwBlockIdBase;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import javax.annotation.Nullable;
import java.util.*;

public abstract class McwItemTags extends ItemTagsProvider implements ITag
{
    public McwItemTags(DataGenerator p_i232552_1_, BlockTagsProvider p_i232552_2_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_i232552_1_, p_i232552_2_, modId, existingFileHelper);
    }

    @Override
    public void buildToTagSystem(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT)
    {
        Map<Block, String> tags = TagsUtils.makeTags(mcwBlockIdBase, modid, MAT, false);

        for(Map.Entry<Block, String> entry : tags.entrySet())
        {
            Block block = entry.getKey();
            String tag = entry.getValue();
            this.tag(TagsUtils.getTagItem(tag)).add(block.asItem());
        }
    }
}