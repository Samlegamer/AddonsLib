package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import java.util.*;

public abstract class McwBlockTags extends FabricTagProvider.BlockTagProvider
{
    public McwBlockTags(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
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

                    this.getOrCreateTagBuilder(getTag(tagBlock)).add(result);
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

    public static TagKey<Block> getTag(String id)
    {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(id));
    }
}