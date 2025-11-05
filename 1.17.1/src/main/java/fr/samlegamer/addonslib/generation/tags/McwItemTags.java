package fr.samlegamer.addonslib.generation.tags;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlockIdBase;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.*;

public abstract class McwItemTags extends ItemTagsProvider
{
    public McwItemTags(DataGenerator p_i232552_1_, BlockTagsProvider p_i232552_2_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_i232552_1_, p_i232552_2_, modId, existingFileHelper);
    }

    public void addAllMcwTags(String modid, List<String> WOOD, List<String> STONE, List<String> LEAVE)
    {
        mcwFencesTags(modid, WOOD, LEAVE, STONE);
        mcwDoorsTagsWood(modid, WOOD);
        mcwTrapdoorsTagsWood(modid, WOOD);
    }

    public void addAllMcwTags(String modid, List<String> WOOD, List<String> LEAVE)
    {
        addAllMcwTags(modid, WOOD, new ArrayList<>(), LEAVE);
    }

    public void addAllMcwTags(String modid, List<String> WOOD)
    {
        addAllMcwTags(modid, WOOD, new ArrayList<>());
    }

    public void mcwFencesTags(String modid, List<String> WOOD, List<String> LEAVE, List<String> STONE)
    {
        Set<Item> blocksWood = new HashSet<>();
        List<Item> blocksLeave = new ArrayList<>();
        Set<Item> blocksStone = new HashSet<>();

        addItems(modid, WOOD, blocksWood, McwBlocksIdBase.FENCES_WOOD_BLOCKS);
        addItems(modid, LEAVE, blocksLeave, McwBlocksIdBase.FENCES_LEAVE_BLOCKS);
        addItems(modid, STONE, blocksStone, McwBlocksIdBase.FENCES_STONE_BLOCKS);

        Item[] picket_fences = getSetWithContain(blocksWood, "picket_fence");
        Item[] stockade_fences = getSetWithContain(blocksWood, "stockade_fence");
        Item[] horse_fences = getSetWithContain(blocksWood, "horse_fence");
        Item[] wired_fences = getSetWithContain(blocksWood, "wired_fence");
        Item[] curved_gates = getSetWithContain(blocksWood, "curved_gate");

        Item[] hedges = listToArray(blocksLeave);

        Item[] modern_wall = getSetWithStartsWith(blocksStone, "modern_");
        Item[] railing_wall = getSetWithStartsWith(blocksStone, "railing_");
        Item[] pillar_wall = getSetWithEndsWith(blocksStone, "_pillar_wall");
        Item[] grass_topped_wall = getSetWithEndsWith(blocksStone, "_grass_topped_wall");

        this.tag(ItemTags.FENCES).add(modern_wall).add(pillar_wall).add(railing_wall)
                .add(picket_fences).add(stockade_fences).add(horse_fences).add(wired_fences).add(curved_gates);
        this.tag(ItemTags.WALLS).add(hedges).add(grass_topped_wall);
        this.tag(ItemTags.WOODEN_FENCES).add(picket_fences).add(stockade_fences).add(horse_fences).add(wired_fences).add(curved_gates);
    }

    public void mcwDoorsTagsWood(String modid, List<String> MAT)
    {
        List<Item> items = new ArrayList<>();
        for(String mat : MAT)
        {
            for(BlockId blockId : McwBlocksIdBase.DOORS_WOOD_BLOCKS.blocks())
            {
                String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                Item block = Finder.findItem(modid, id);
                items.add(block);
            }
        }

        Item[] itemArray = listToArray(items);
        this.tag(ItemTags.WOODEN_DOORS).add(itemArray);
    }

    public void mcwTrapdoorsTagsWood(String modid, List<String> MAT)
    {
        List<Item> items = new ArrayList<>();
        for(String mat : MAT)
        {
            for(BlockId blockId : McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS.blocks())
            {
                String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                Item block = Finder.findItem(modid, id);
                items.add(block);
            }
        }

        Item[] itemArray = listToArray(items);
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(itemArray);
    }

    public static Tag.Named<Block> getTag(String id, String tagName)
    {
        return BlockTags.createOptional(new ResourceLocation(id, tagName));
    }

    private Item[] getSetWithContain(Set<Item> blocks, String contain)
    {
        List<Item> finalBlocks = new ArrayList<>();
        for(Item block : blocks)
        {
            if(Objects.requireNonNull(block.getRegistryName()).getPath().contains(contain))
            {
                finalBlocks.add(block);
            }
        }
        return listToArray(finalBlocks);
    }

    private Item[] getSetWithEndsWith(Set<Item> blocks, String endsWith)
    {
        List<Item> finalBlocks = new ArrayList<>();
        for(Item block : blocks)
        {
            if(Objects.requireNonNull(block.getRegistryName()).getPath().endsWith(endsWith))
            {
                finalBlocks.add(block);
            }
        }
        return listToArray(finalBlocks);
    }

    private Item[] getSetWithStartsWith(Set<Item> blocks, String startsWith)
    {
        List<Item> finalBlocks = new ArrayList<>();
        for(Item block : blocks)
        {
            if(Objects.requireNonNull(block.getRegistryName()).getPath().startsWith(startsWith))
            {
                finalBlocks.add(block);
            }
        }
        return listToArray(finalBlocks);
    }

    private Item[] listToArray(List<Item> finalBlocks)
    {
        Item[] blockArray = new Item[finalBlocks.size()];

        for(int i = 0; i < finalBlocks.size(); i++)
        {
            blockArray[i] = finalBlocks.get(i);
        }
        return blockArray;
    }


    private void addItems(String modid, List<String> MAT, Collection<Item> blockSet, McwBlockIdBase blocks)
    {
        for(String mat : MAT)
        {
            for(BlockId blockId : blocks.blocks())
            {
                String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                Item item = Finder.findItem(modid, id);
                blockSet.add(item);
            }
        }
    }
}