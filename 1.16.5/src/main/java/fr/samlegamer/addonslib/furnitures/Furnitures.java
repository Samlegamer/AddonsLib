package fr.samlegamer.addonslib.furnitures;

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

public class Furnitures
{
	public static final String modid = "mcwfurnitures";
	/**
	 * Init all Wood Variants of Macaw's Furnitures
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}

	/**
	 * Init all Wood Variants of Macaw's Furnitures with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FURNITURES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					if(blockId.reflectedLocation().contains("StorageCounter") || blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet") ||
							blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter") ||
							blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge")) {
						CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, true, isModBaseLoaded);
					}
					else {
						CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, true, isModBaseLoaded);
					}
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> set, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FURNITURES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					if(blockId.reflectedLocation().contains("StorageCounter") || blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet") ||
							blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter") ||
							blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge")) {
						CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab, true);
					}
					else {
						CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD), tab, true);
					}
				}
				else {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new Block(WOOD), tab, false);
				}
			}
		}
	}
}