package fr.samlegamer.addonslib;

import fr.samlegamer.addonslib.cfg.Cfg;
import fr.samlegamer.addonslib.generation.loot_tables.LootModRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

@Mod(AddonsLib.MODID)
public class AddonsLib
{
	public static final String MODID = "addonslib";
	public static final Logger LOGGER = LogManager.getLogger();
//    private static final DeferredRegister<Block> BLOCKS = Registration.blocks(MODID);
//    public static final DeferredRegister<Item> ITEMS = Registration.items(MODID);

	public AddonsLib()
	{
//        Registration.init(BLOCKS, ITEMS);
//        RegistryObject<Block> my_block = BLOCKS.register("my_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.STONE)));
//        RegistryObject<Item> my_block_item = ITEMS.register("my_block", () -> new BlockItem(my_block.get(), new Item.Properties()));
        LootModRegistry.SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Cfg.SPEC, "addonslib-common.toml");
		LOGGER.info("AddonsLib Forge !");
		if(Cfg.filterLogs.get())
		{
			addCustomFilter();
		}
	}

	private void addCustomFilter() {
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		Configuration config = context.getConfiguration();
		LoggerConfig loggerConfig = config.getLoggerConfig("net.minecraft.client");

		loggerConfig.addFilter(new CustomLogFilter());
		context.updateLoggers();
	}
}