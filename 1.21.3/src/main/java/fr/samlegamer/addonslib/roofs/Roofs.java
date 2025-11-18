package fr.samlegamer.addonslib.roofs;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Roofs
{
	private static final BlockBehaviour.Properties wood = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
	private static final BlockBehaviour.Properties stone = BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE);
	public static final String modid = "mcwroofs";
		
	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationWoodModLoaded(set, block, item, wood);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationRockModLoaded(rock, block, item, stone);
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
    public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
    {
        final BlockBehaviour.Properties WOOD = prop;
        boolean isModMcwLoaded = ModList.get().isLoaded(modid);

        for (String i : set) {
            for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
                String id = McwBlocksIdBase.replacement(blockId.id(), i);

                if(isModMcwLoaded) {
                    if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep") || blockId.reflectedLocation().contains("BaseRoof")) {
                        CreateBlockReferences.createBlock(id, () ->
                                Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(block.key(id)), Blocks.OAK_PLANKS.defaultBlockState()), block, item);
                    } else {
                        CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(block.key(id))), block, item);
                    }
                }
                else {
                    CreateBlockReferences.createBlock(id, () -> new Block(WOOD.setId(block.key(id))), block, item);
                }
            }
        }
    }

    /**
     * Init all Stone Variants of Macaw's Roofs
     */
    public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
    {
        final BlockBehaviour.Properties STONE = prop;
        boolean isModMcwLoaded = ModList.get().isLoaded(modid);

        for (String i : rock) {
            for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
                String id = McwBlocksIdBase.replacement(blockId.id(), i);

                if(isModMcwLoaded) {
                    if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep") || blockId.reflectedLocation().contains("BaseRoof")) {
                        CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE.setId(block.key(id)), Blocks.COBBLESTONE.defaultBlockState()), block, item);
                    } else {
                        CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE.setId(block.key(id))), block, item);
                    }
                }
                else {
                    CreateBlockReferences.createBlockStone(id, () -> new Block(STONE.setId(block.key(id))), block, item);
                }
            }
        }
    }
}