package fr.samlegamer.addonslib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

public class AddonsLib
{
    public static final String MODID = "addonslib";
    public static final Logger LOGGER = LogManager.getLogger();

	public static void addCustomFilter() {
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		Configuration config = context.getConfiguration();
		LoggerConfig loggerConfig = config.getLoggerConfig("net.minecraft.client");

		loggerConfig.addFilter(new CustomLogFilter());
		context.updateLoggers();
	}
}