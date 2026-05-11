package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.McwBlockIdBase;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.world.level.block.Block;
import java.util.*;

public abstract class McwBlockTags extends FabricTagProvider.BlockTagProvider implements ITag
{
    public McwBlockTags(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
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