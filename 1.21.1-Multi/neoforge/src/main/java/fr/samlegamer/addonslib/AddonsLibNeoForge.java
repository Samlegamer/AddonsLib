package fr.samlegamer.addonslib;

import fr.samlegamer.addonslib.cfg.Cfg;
import fr.samlegamer.addonslib.generation.loot_tables.LootModRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;

@Mod(AddonsLib.MODID)
public class AddonsLibNeoForge
{
	public AddonsLibNeoForge(IEventBus bus, ModContainer container)
	{
		LootModRegistry.SERIALIZERS.register(bus);
		container.registerConfig(ModConfig.Type.STARTUP, Cfg.SPEC, "addonslib-common.toml");
		AddonsLib.LOGGER.info("AddonsLib NeoForge !");
		bus.addListener(this::onConfigLoaded);
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