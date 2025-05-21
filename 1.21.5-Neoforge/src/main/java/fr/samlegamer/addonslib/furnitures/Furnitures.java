package fr.samlegamer.addonslib.furnitures;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Furnitures
{
	public static final String modid = "mcwfurnitures";
	
	/**
	 * Init all Wood Variants of Macaw's Furnitures
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
		setRegistrationWoodModLoaded(set, block, item, WOOD);
	}

	/**
	 * Init all Wood Variants of Macaw's Furnitures with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;
		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FURNITURES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					if(blockId.reflectedLocation().contains("StorageCounter") || blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet")) {
						CreateBlockReferences.createBlock(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.OAK_PLANKS.defaultBlockState()), block, item);
					}
					else {
						CreateBlockReferences.createBlock(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
					}
				}
				else {
					CreateBlockReferences.createBlock(id, registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}
	}
}