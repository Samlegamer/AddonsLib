package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.ModType;
import fr.addonslib.api.obj.DoubleObject;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public abstract class McwItemTags extends ItemTagsProvider implements ITag
{
    public McwItemTags(PackOutput p_255871_, CompletableFuture<HolderLookup.Provider> p_256035_, TagsProvider<Block> p_256467_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255871_, p_256035_, p_256467_, modId, existingFileHelper);
    }

    @Override
    public void buildToTagSystem(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT)
    {
        Map<DoubleObject<String, String>, String> tags = TagsUtils.makeTags(mcwBlockIdBase, modid, MAT, false);

        for(Map.Entry<DoubleObject<String, String>, String> entry : tags.entrySet())
        {
            Block block = Finder.findBlock(entry.getKey().getFirst(), entry.getKey().getSecond());
            String tagName = entry.getValue();

            if(tagName != null && !tagName.isEmpty() && block != Blocks.AIR)
            {
                this.tag(getTag(tagName)).add(block.asItem());
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

    public static TagKey<Item> getTag(String modidTagName)
    {
        return ItemTags.create(TagsUtils.parseResourceLocation(modidTagName));
    }
}