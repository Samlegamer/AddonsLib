package fr.samlegamer.addonslib.generation.loot_tables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;

import java.util.concurrent.CompletableFuture;

public abstract class McwLootTables extends FabricBlockLootTableProvider
{
    protected final LootTableUtils lootTableUtils;

    protected McwLootTables(FabricDataOutput dataGenerator, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataGenerator, registryLookup);
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