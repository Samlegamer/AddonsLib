package fr.samlegamer.addonslib;

import fr.samlegamer.addonslib.cfg.Cfg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

public class AddonsLib implements ModInitializer
{
	public static final String MODID = "addonslib";
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public void onInitialize()
	{
		LOGGER.info("AddonsLib Fabric !");
		Cfg.initCfg();
		if(Cfg.getFilterLogs())
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