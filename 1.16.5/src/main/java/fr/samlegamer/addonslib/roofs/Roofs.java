package fr.samlegamer.addonslib.roofs;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Roofs
{
	public static final String modid = "mcwroofs";
	
	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", AbstractBlock.Properties.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		setRegistrationRockModLoaded(rock, block, item, tab, "minecraft", AbstractBlock.Properties.copy(Blocks.COBBLESTONE));
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
        final AbstractBlock.Properties WOOD = prop;

        boolean isModMcwLoaded = ModList.get().isLoaded(modid);
        boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

        for (String i : set) {
            for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
                String id = McwBlocksIdBase.replacement(blockId.id(), i);

                if(isModMcwLoaded) {
                    if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep") || blockId.reflectedLocation().contains("BaseRoof")) {
                        CreateBlockReferences.createBlock(id, () ->
                                Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, true, isModBaseLoaded);
                    } else {
                        CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, true, isModBaseLoaded);
                    }
                }
                else {
                    CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item, tab, false, isModBaseLoaded);
                }
            }
        }
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		final AbstractBlock.Properties STONE = prop;

        boolean isModMcwLoaded = ModList.get().isLoaded(modid);
        boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

        for (String i : rock) {
            for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
                String id = McwBlocksIdBase.replacement(blockId.id(), i);

                if(isModMcwLoaded) {
                    if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep") || blockId.reflectedLocation().contains("BaseRoof")) {
                        CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE, Blocks.COBBLESTONE.defaultBlockState()), block, item, tab, true, isModBaseLoaded);
                    } else {
                        CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item, tab, true, isModBaseLoaded);
                    }
                }
                else {
                    CreateBlockReferences.createBlockStone(id, () -> new Block(STONE), block, item, tab, false, isModBaseLoaded);
                }
            }
        }
	}
	
	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> set, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

        boolean isModLoaded = ModList.get().isLoaded(modid);

        for (String i : set) {
            for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
                String id = McwBlocksIdBase.replacement(blockId.id(), i);

                if(isModLoaded) {
                    if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep") || blockId.reflectedLocation().contains("BaseRoof")) {
                        CreateBlockReferences.createBlockWoodOpti(Modid, id,
                                Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab, true);
                    } else {
                        CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD), tab, true);
                    }
                }
                else {
                    CreateBlockReferences.createBlockWoodOpti(Modid, id, new Block(WOOD), tab, false);
                }
            }
        }
	}
	
	public static void registryStone(final RegistryEvent.Register<Block> event, String Modid, List<String> rock, ItemGroup tab)
	{
		final AbstractBlock.Properties STONE = AbstractBlock.Properties.copy(Blocks.COBBLESTONE);

        boolean isModLoaded = ModList.get().isLoaded(modid);

        for (String i : rock) {
            for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
                String id = McwBlocksIdBase.replacement(blockId.id(), i);

                if(isModLoaded) {
                    if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep") || blockId.reflectedLocation().contains("BaseRoof")) {
                        CreateBlockReferences.createBlockStoneOpti(Modid, id,
                                Registration.getBlocksField(blockId.reflectedLocation(), STONE, Blocks.COBBLESTONE.defaultBlockState()), tab, true);
                    } else if (!blockId.reflectedLocation().contains("StairsBlock")) {
                        CreateBlockReferences.createBlockStoneOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), STONE), tab, true);
                    }
                }
                else {
                    CreateBlockReferences.createBlockStoneOpti(Modid, id, new Block(STONE), tab, false);
                }
            }
        }
	}
}