package fr.samlegamer.addonslib.util;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public abstract class McwMod {

    public McwMod() {}

    public abstract void clientSetup(FMLClientSetupEvent event);
    public abstract void commonSetup(FMLCommonSetupEvent event);
    public abstract void dataSetup(GatherDataEvent event);

    public IEventBus getBus()
    {
        return FMLJavaModLoadingContext.get().getModEventBus();
    }
}
