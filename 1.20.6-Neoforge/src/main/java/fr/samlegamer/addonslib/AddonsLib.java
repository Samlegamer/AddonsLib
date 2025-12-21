package fr.samlegamer.addonslib;

import fr.samlegamer.addonslib.cfg.Cfg;
import fr.samlegamer.addonslib.generation.loot_tables.LootModRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

@Mod(AddonsLib.MODID)
public class AddonsLib
{
	public static final String MODID = "addonslib";
	public static final Logger LOGGER = LogManager.getLogger();

    public AddonsLib(IEventBus bus, ModContainer container)
    {
        LootModRegistry.SERIALIZERS.register(bus);
        container.registerConfig(ModConfig.Type.COMMON, Cfg.SPEC, "addonslib-common.toml");
        LOGGER.info("AddonsLib Forge !");
        bus.addListener(this::onConfigLoaded);
    }

    private void onConfigLoaded(final ModConfigEvent.Loading event)
    {
        if (event.getConfig().getSpec() == Cfg.SPEC)
        {
            if (Cfg.filterLogs.get())
            {
                addCustomFilter();
            }
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