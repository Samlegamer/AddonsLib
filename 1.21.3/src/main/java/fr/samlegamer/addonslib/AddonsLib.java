package fr.samlegamer.addonslib;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;

@Mod(AddonsLib.MODID)
public class AddonsLib
{
	public static final String MODID = "addonslib";
	public static final Logger LOGGER = LogManager.getLogger();
	private static BlockBehaviour.Properties wood = BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.WOOD);

	public AddonsLib(FMLJavaModLoadingContext context)
	{
		LOGGER.info("AddonsLib is loaded!");
		LOGGER.info("Registering blocks...");
		// Example of how to register a block
		// This is just a placeholder, you should replace it with your actual block registration code
		// Assuming you have a BlockRegistry class that handles block registration
		final DeferredRegister<Block> block = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
		block.register(context.getModEventBus());
		final RegistryObject<Block> a = block.register("bridge_block", () -> new Block(wood.setId(block.key("bridge_block"))) );

	}
}