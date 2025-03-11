package fr.samlegamer.addonslib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class AddonsLib implements ModInitializer
{
	public static final String MODID = "addonslib";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	@Override
	public void onInitialize()
	{
		LOGGER.info("AddonsLib Fabric !");
	}
	
	public static boolean isLoaded(String modid)
	{
		return FabricLoader.getInstance().isModLoaded(modid);
	}
}