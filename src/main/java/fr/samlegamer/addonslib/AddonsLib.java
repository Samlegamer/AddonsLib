package fr.samlegamer.addonslib;

import net.minecraftforge.fml.common.Mod;

@Mod(AddonsLib.MODID)
public class AddonsLib
{
	/*For 1.17+ add ModList.isLoaded("") in block registration*/
	public static final String MODID = "addonslib";

	//final ItemGroup ADDONS_TAB = TabUtils.tab(MODID, Bridges.getBridgeBlocks().get(0).get());
/*
	public static final ItemGroup ADDONS_TAB = new ItemGroup(MODID + "_tab") {
	    @Override
	    public ItemStack makeIcon() {
	        return new ItemStack(Bridges.getBridgeBlocks().get(0).get());
	    }
	};*/

    public AddonsLib()
    {
    	/*final DeferredRegister<Block> regiBlock = Registration.blocks(MODID);
    	final DeferredRegister<Item> regiItem = Registration.items(MODID);
    	Registration.init(regiBlock, regiItem);
    	List<String> mat = List.of("cherry", "willow");
    	List<String> rock = List.of("soulsandsotne", "andesite_brick");
    	Bridges.setRegistrationWood(mat, regiBlock, regiItem, ADDONS_TAB);
    	Fences.setRegistrationWood(mat, regiBlock, regiItem, ADDONS_TAB);
    	Fences.setRegistrationHedges(mat, regiBlock, regiItem, ADDONS_TAB);
    	Fences.setRegistrationRock(rock, regiBlock, regiItem, ADDONS_TAB);
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(Bridges::setupClient);
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(Fences::setupClient);*/
    	//Bridges.setRenderWood(mat, MODID, regiBlock);
    	//final RegistryObject<Block> block = RegistryObject.of(new ResourceLocation(MODID+":"+mat.get(0)+"_log_bridge_middle"), ForgeRegistries.BLOCKS);	
    	//tab = new AddonsTab(MODID+"tab", Bridges.getTabIcon());
    }
    
    
}