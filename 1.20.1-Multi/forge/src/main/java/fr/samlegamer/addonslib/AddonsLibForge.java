package fr.samlegamer.addonslib;

import fr.samlegamer.addonslib.cfg.Cfg;
import fr.samlegamer.addonslib.generation.loot_tables.LootModRegistry;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(AddonsLib.MODID)
public class AddonsLibForge
{
	public AddonsLibForge()
	{
        LootModRegistry.SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Cfg.SPEC, "addonslib-common.toml");
		AddonsLib.LOGGER.info("AddonsLib Forge !");
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onConfigLoaded);
	}

	private void onConfigLoaded(final ModConfigEvent.Loading event)
	{
		if (event.getConfig().getSpec() == Cfg.SPEC)
		{
			if (Cfg.filterLogs.get())
			{
				AddonsLib.addCustomFilter();
			}
		}
	}

}