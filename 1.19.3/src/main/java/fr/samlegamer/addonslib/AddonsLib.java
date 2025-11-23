package fr.samlegamer.addonslib;

import fr.samlegamer.addonslib.cfg.Cfg;
import fr.samlegamer.addonslib.generation.loot_tables.LootModRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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

    public AddonsLib()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        LootModRegistry.SERIALIZERS.register(eventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Cfg.SPEC, "addonslib-common.toml");
        LOGGER.info("AddonsLib Forge !");
        eventBus.addListener(this::onConfigLoaded);
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