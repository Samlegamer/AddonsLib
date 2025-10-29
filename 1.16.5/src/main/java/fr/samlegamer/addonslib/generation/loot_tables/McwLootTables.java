package fr.samlegamer.addonslib.generation.loot_tables;

import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlockIdBase;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.*;

public class McwLootTables extends LootModifier
{
    private static Set<Block> blockSet = new HashSet<>();

    protected McwLootTables(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    public ILootCondition[] conditions() {
        return this.conditions;
    }

    public static void addBlock(String modid, List<String> MAT, McwBlockIdBase blocks)
    {
        for(String mat : MAT) {
            for(BlockId id : blocks.blocks()) {
                String blockName = McwBlocksIdBase.replacement(id.id(), mat);
                Block block = Finder.findBlock(modid, blockName);

                if(block != null) {
                    blockSet.add(block);
                } else {
                    AddonsLib.LOGGER.info("[McwLootTables] ERROR: Block not found: {}:{}", modid, blockName);
                }
            }
        }
    }

    public static void addBlockAllWood(String modid, List<String> MAT_WOOD)
    {
        addBlock(modid, MAT_WOOD, McwBlocksIdBase.BRIDGES_WOOD_BLOCKS);
        addBlock(modid, MAT_WOOD, McwBlocksIdBase.ROOFS_WOOD_BLOCKS);
        addBlock(modid, MAT_WOOD, McwBlocksIdBase.FENCES_WOOD_BLOCKS);
        addBlock(modid, MAT_WOOD, McwBlocksIdBase.FURNITURES_WOOD_BLOCKS);
        addBlock(modid, MAT_WOOD, McwBlocksIdBase.STAIRS_WOOD_BLOCKS);
        addBlock(modid, MAT_WOOD, McwBlocksIdBase.PATHS_WOOD_BLOCKS);
        addBlock(modid, MAT_WOOD, McwBlocksIdBase.DOORS_WOOD_BLOCKS);
        addBlock(modid, MAT_WOOD, McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS);
        addBlock(modid, MAT_WOOD, McwBlocksIdBase.WINDOWS_WOOD_BLOCKS);
    }

    public static void addBlockHedges(String modid, List<String> MAT_LEAVE)
    {
        addBlock(modid, MAT_LEAVE, McwBlocksIdBase.FENCES_LEAVE_BLOCKS);
    }

    public static void addBlockAllStone(String modid, List<String> MAT_ROCK)
    {
        addBlock(modid, MAT_ROCK, McwBlocksIdBase.BRIDGES_STONE_BLOCKS);
        addBlock(modid, MAT_ROCK, McwBlocksIdBase.ROOFS_STONE_BLOCKS);
        addBlock(modid, MAT_ROCK, McwBlocksIdBase.FENCES_STONE_BLOCKS);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        BlockState state = context.getParamOrNull(LootParameters.BLOCK_STATE);

        if(state != null && blockSet.contains(state.getBlock()))
        {
            generatedLoot.clear();
            generatedLoot.add(new ItemStack(state.getBlock(), 1));
        }

        return generatedLoot;
    }
}
