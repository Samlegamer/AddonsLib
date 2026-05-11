package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.McwBlockIdBase;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import java.util.*;

public abstract class McwItemTags extends FabricTagProvider.ItemTagProvider implements ITag
{
    public McwItemTags(FabricDataGenerator dataGenerator, @Nullable BlockTagProvider blockTagProvider) {
        super(dataGenerator, blockTagProvider);
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