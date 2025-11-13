package fr.samlegamer.addonslib.windows;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Windows
{
	public static final String modid = "mcwwindows";
	
	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationWoodModLoaded(set, block, item, BlockBehaviour.Properties.of().sound(SoundType.WOOD));
	}
	
	/**
	 * Init all Wood Variants of Macaw's Windows with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop.strength(0.6F, 1.2F);
		final BlockBehaviour.Properties PARAPET = prop.strength(0.2F, 1.0F);
		final BlockBehaviour.Properties BLINDS = prop.strength(0.3F, 1.0F);
		final BlockBehaviour.Properties SHUTTER = prop.strength(0.5F, 2.0F);
		final BlockBehaviour.Properties ROD = prop.strength(0.3F, 0.7F);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.WINDOWS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);
				String relectedLocation = blockId.reflectedLocation();

				if(isModLoaded) {
					switch (relectedLocation)
					{
						case "Parapet":
							CreateBlockReferences.createBlock(id, registryName ->
											Registration.getBlocksField(relectedLocation, PARAPET),
									block, item);
							break;
						case "Blinds":
							CreateBlockReferences.createBlock(id, registryName ->
											Registration.getBlocksField(relectedLocation, BLINDS),
									block, item);
							break;
						case "Shutter":
							CreateBlockReferences.createBlock(id, registryName ->
											Registration.getBlocksField(relectedLocation, SHUTTER),
									block, item);
							break;
						case "CurtainRod":
							CreateBlockReferences.createBlock(id, registryName ->
											Registration.getBlocksField(relectedLocation, ROD),
									block, item);
							break;
						default:
							CreateBlockReferences.createBlock(id, registryName ->
											Registration.getBlocksField(relectedLocation, WOOD),
									block, item);
							break;
					}
				}
				else {
					CreateBlockReferences.createBlock(id, registryName -> new Block(WOOD), block, item);
				}
			}
		}
	}
}