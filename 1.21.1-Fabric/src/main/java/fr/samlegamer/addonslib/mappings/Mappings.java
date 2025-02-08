package fr.samlegamer.addonslib.mappings;

import java.io.File;
import java.io.IOException;

import net.fabricmc.loader.api.FabricLoader;

public final class Mappings
{
	private Mappings() {}
	
	public static void init()
	{
        File file = FabricLoader.getInstance().getConfigDir().resolve("configurabledatafixers.json5").toFile();

        if(!file.exists())
        {
        	try {
				file.createNewFile();
    		}			
        	catch (IOException e)
			{
				e.printStackTrace();
			}

        }
	}
}
