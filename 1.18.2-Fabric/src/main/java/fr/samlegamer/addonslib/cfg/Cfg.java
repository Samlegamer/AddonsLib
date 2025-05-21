package fr.samlegamer.addonslib.cfg;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import fr.samlegamer.addonslib.AddonsLib;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cfg
{
    public static void initCfg()
    {
        if(!FabricLoader.getInstance().getConfigDir().resolve("addonslib-common.json").toFile().exists())
        {
            try (JsonWriter writer = new JsonWriter(new FileWriter(FabricLoader.getInstance().getConfigDir().toString() + File.separator + "addonslib-common.json"))) {
                writer.beginObject();
                writer.name("filterLogs").value(true);
                writer.endObject();
                AddonsLib.LOGGER.info("AddonsLib config file created: addonslib-common.json");
            } catch (IOException e) {
                AddonsLib.LOGGER.error(e);
            }
        }
    }

    public static boolean getFilterLogs()
    {
        try {
            File configFile = FabricLoader.getInstance().getConfigDir().resolve("addonslib-common.json").toFile();
            if (configFile.exists()) {
                Gson gson = new Gson();
                JsonObject json = gson.fromJson(new FileReader(configFile), JsonObject.class);
                if (json.has("filterLogs") && json.get("filterLogs").isJsonPrimitive()) {
                    return json.get("filterLogs").getAsBoolean();
                }
            }
        } catch (IOException e) {
            AddonsLib.LOGGER.error("Failed to read config file: addonslib-common.json", e);
        }
        return true;
    }
}
