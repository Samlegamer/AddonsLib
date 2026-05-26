package fr.samlegamer.addonslib.generation.loot_tables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;

public abstract class McwLootTables extends FabricBlockLootTableProvider
{
    protected final LootTableUtils lootTableUtils;

    protected McwLootTables(FabricDataOutput dataGenerator) {
        super(dataGenerator);
        this.lootTableUtils = new LootTableUtils();
    }

    protected void makeLootTables() {
        for (Block block : lootTableUtils.getBlockSet()) {
            if(block instanceof DoorBlock)
            {
                this.doorDrop(block);
            }
            else
            {
                this.dropSelf(block);
            }
        }
    }

    protected void doorDrop(Block block) {
        this.add(block, blockLootTable -> createDoorTable(block));
    }
}