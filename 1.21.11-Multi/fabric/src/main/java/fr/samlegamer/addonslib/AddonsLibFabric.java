package fr.samlegamer.addonslib;

import fr.samlegamer.addonslib.cfg.Cfg;
import net.fabricmc.api.ModInitializer;

public class AddonsLibFabric implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		AddonsLib.LOGGER.info("AddonsLib Fabric !");
		Cfg.initCfg();
		if(Cfg.getFilterLogs())
		{
			AddonsLib.addCustomFilter();
		}
	}
}