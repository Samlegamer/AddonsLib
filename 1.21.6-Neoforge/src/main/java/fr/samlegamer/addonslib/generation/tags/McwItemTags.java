package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public abstract class McwItemTags extends ItemTagsProvider
{
    public McwItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(output, lookupProvider, modId);
    }

    // For Compat with old and new tags system
    public McwItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, String modId) {
        this(output, lookupProvider, modId);
    }

    private void makeTags(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT)
    {
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            for(String tagBlock : blockId.tags().getTagsItem())
            {
                for (String mat : MAT)
                {
                    Item result = Finder.findItem(modid, McwBlocksIdBase.replacement(blockId.id(), mat));

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

    public static TagKey<Item> getTag(String modidTagName)
    {
        return ItemTags.create(ResourceLocation.parse(modidTagName));
    }
}