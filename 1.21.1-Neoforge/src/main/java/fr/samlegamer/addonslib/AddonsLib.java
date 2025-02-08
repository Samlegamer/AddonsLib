package fr.samlegamer.addonslib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.neoforged.fml.common.Mod;

@Mod(AddonsLib.MODID)
public class AddonsLib
{
	public static final String MODID = "addonslib";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public AddonsLib()
	{
		LOGGER.info("AddonsLib Neoforge !");
	}
}