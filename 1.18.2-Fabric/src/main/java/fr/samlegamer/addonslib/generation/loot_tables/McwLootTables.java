package fr.samlegamer.addonslib.generation.loot_tables;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class McwLootTables extends FabricBlockLootTableProvider
{
    private final Set<Block> blockSet;

    protected McwLootTables(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
        this.blockSet = new HashSet<>();
    }

    protected Set<Block> getBlockSet() {
        return blockSet;
    }

    protected void addBlock(String modid, List<String> MAT, McwBlockIdBase blocks)
    {
        for(String mat : MAT) {
            for(BlockId id : blocks.blocks()) {
                String blockName = McwBlocksIdBase.replacement(id.id(), mat);
                Block block = Finder.findBlock(modid, blockName);

                if(block != null) {
                    if(!Finder.getIdOfBlock(block).endsWith("_balcony")) {
                        blockSet.add(block);
                    }
                } else {
                    AddonsLib.LOGGER.info("[McwLootTables] ERROR: Block not found: {}:{}", modid, blockName);
                }
            }
        }
    }

    protected void addBlockAllWood(String modid, List<String> MAT_WOOD)
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

    protected void addBlockHedges(String modid, List<String> MAT_LEAVE)
    {
        addBlock(modid, MAT_LEAVE, McwBlocksIdBase.FENCES_LEAVE_BLOCKS);
    }

    protected void addBlockAllStone(String modid, List<String> MAT_ROCK)
    {
        addBlock(modid, MAT_ROCK, McwBlocksIdBase.BRIDGES_STONE_BLOCKS);
        addBlock(modid, MAT_ROCK, McwBlocksIdBase.ROOFS_STONE_BLOCKS);
        addBlock(modid, MAT_ROCK, McwBlocksIdBase.FENCES_STONE_BLOCKS);
    }

    protected void makeLootTables() {
        for (Block block : blockSet) {
            if(block instanceof DoorBlock)
            {
                this.doorDrop(block);
            }
            else
            {
                this.addDrop(block);
            }
        }
    }

    protected void doorDrop(Block block) {
        this.addDrop(block, blockLootTable -> addDoorDrop(block));
    }
}