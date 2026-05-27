package fr.samlegamer.addonslib.util;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public abstract class McwMod {

    public McwMod(IEventBus bus) {}

    public abstract void clientSetup(FMLClientSetupEvent event);
    public abstract void commonSetup(FMLCommonSetupEvent event);
    public abstract void dataSetup(GatherDataEvent event);
    public abstract void tabSetup(BuildCreativeModeTabContentsEvent event);
}
