package fr.samlegamer.addonslib.util;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public abstract class McwMod {

    public abstract void clientSetup(FMLClientSetupEvent event);
    public abstract void commonSetup(FMLCommonSetupEvent event);
    public abstract void dataSetup(GatherDataEvent event);

    protected IEventBus bus()
    {
        return FMLJavaModLoadingContext.get().getModEventBus();
    }
}
