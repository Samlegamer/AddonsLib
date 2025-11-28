package fr.samlegamer.addonslib.generation.loot_tables;

import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlockIdBase;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.*;

public class McwLootTables extends LootModifier
{
    private static final Set<Block> blockSet = new HashSet<>();

    protected McwLootTables(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    public LootItemCondition[] conditions() {
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
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext lootContext) {
        BlockState state = lootContext.hasParam(LootContextParams.BLOCK_STATE) ? lootContext.getParam(LootContextParams.BLOCK_STATE) : null;

        if (state != null) {
            if (state instanceof BlockState) {
                if (blockSet.contains(state.getBlock())) {
                    if (state.getBlock() instanceof DoorBlock) {
                        try {
                            DoubleBlockHalf half = state.getValue(DoorBlock.HALF);
                            if (half == DoubleBlockHalf.UPPER) {
                                generatedLoot.clear();
                                return generatedLoot;
                            }
                        } catch (Exception e) {
                            AddonsLib.LOGGER.error("[McwLootTables] ERROR: Can't get the double block half of the door: {}", e.getMessage());
                        }
                    }

                    generatedLoot.clear();
                    generatedLoot.add(new ItemStack(state.getBlock(), 1));
                }
            }
        }
        return generatedLoot;
    }
}
