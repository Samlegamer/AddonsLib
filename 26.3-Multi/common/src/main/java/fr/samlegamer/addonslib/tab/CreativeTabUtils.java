package fr.samlegamer.addonslib.tab;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.util.IModList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CreativeTabUtils {

    public static Set<ItemStack> getWoodItemForCreativeTab(IModList modList, String MODID, List<String> WOOD, String modidCharged, ModType... type)
    {
        Set<ItemStack> blockSet = new LinkedHashSet<>();

        for (ModType mod : type) {
            if (modList.isLoaded(mod.getModid()) && modList.isLoaded(modidCharged)) {
                final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidWood(mod);

                for (String mat : WOOD) {
                    for (BlockId id : blocks.blocks()) {
                        final Item block = Finder.findItem(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                        blockSet.add(block.getDefaultInstance());
                    }
                }
            }
        }
        return blockSet;
    }

    public static Set<ItemStack> getHedgeItemForCreativeTab(IModList modList, String MODID, List<String> LEAVE, String modidCharged)
    {
        Set<ItemStack> blockSet = new LinkedHashSet<>();

        if (modList.isLoaded(ModType.FENCES.getModid()) && modList.isLoaded(modidCharged)) {
            final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);

            for (String mat : LEAVE) {
                for (BlockId id : blocks.blocks()) {
                    final Item block = Finder.findItem(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                    blockSet.add(block.getDefaultInstance());
                }
            }
        }
        return blockSet;
    }

    public static Set<ItemStack> getStoneItemForCreativeTab(IModList modList, String MODID, List<String> STONE, String modidCharged, ModType... type)
    {
        Set<ItemStack> blockSet = new LinkedHashSet<>();

        for (ModType mod : type) {
            if (modList.isLoaded(mod.getModid()) && modList.isLoaded(modidCharged)) {
                final McwBlockIdBase blocks = McwBlocksIdBase.getBlocksWithModidStone(mod);

                for (String mat : STONE) {
                    for (BlockId id : blocks.blocks()) {
                        final Item block = Finder.findItem(MODID, McwBlocksIdBase.replacement(id.id(), mat));
                        blockSet.add(block.getDefaultInstance());
                    }
                }
            }
        }
        return blockSet;
    }
}
