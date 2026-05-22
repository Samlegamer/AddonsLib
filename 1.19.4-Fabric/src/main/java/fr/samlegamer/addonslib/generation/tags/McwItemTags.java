package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.ModType;
import fr.addonslib.api.obj.DoubleObject;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public abstract class McwItemTags extends FabricTagProvider.ItemTagProvider implements ITag
{
    public McwItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
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
                this.getOrCreateTagBuilder(getTag(tagName)).add(block.asItem());
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
        return TagKey.create(Registries.ITEM, TagsUtils.parseResourceLocation(modidTagName));
    }
}