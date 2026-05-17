package fr.samlegamer.addonslib.registry;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static fr.addonslib.api.registry.ConditionalsRegistry.*;

/*
 * Registry helper for MCW based mods
 */
public final class McwRegistry
{
    private McwRegistry() {}
    
    public static void setRegistriesWood(String MODID, List<String> list, CreativeModeTab tab, ModType... type)
    {
        setRegistriesWood(MODID, RegistryUtils.makeDefaultFromList(list, SoundType.WOOD), tab, type);
    }

    public static void setRegistriesWood(String MODID, Map<String, SoundType> stringSoundTypeMap, CreativeModeTab tab, ModType... type)
    {
        setRegistriesWood(MODID, stringSoundTypeMap, AddonsLib.MODID, tab, type);
    }

    public static void setRegistriesWood(String MODID, List<String> list, String modLoadedTab, CreativeModeTab tab, ModType... type)
    {
        setRegistriesWood(MODID, RegistryUtils.makeDefaultFromList(list, SoundType.WOOD), modLoadedTab, tab, type);
    }

    public static void setRegistriesWood(String MODID, Map<String, SoundType> stringSoundTypeMap, String modLoadedTab, CreativeModeTab tab, ModType... type)
    {
        FabricLoader modList = FabricLoader.getInstance();
        boolean isModBaseLoaded = modList.isModLoaded(modLoadedTab);
        Map<String, SoundType> orderedMap = new LinkedHashMap<>(stringSoundTypeMap);

        for(ModType mod : type)
        {
            for(Map.Entry<String, SoundType> map : orderedMap.entrySet())
            {
                String mat = map.getKey();
                SoundType soundType = map.getValue();

                McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidWood(mod);
                for(BlockId blockId : mcwBlockIdBase.blocks())
                {
                    String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                    String reflectedLocation = blockId.reflectedLocation().getFabric();
                    BlockBehaviour.Properties prop = McwProperties.getWoodProperties(mat, mod).sound(soundType);;
                    boolean isModLoaded = modList.isModLoaded(mcwBlockIdBase.modid());


                    if(isModLoaded)
                    {
                        if(isBlockDefaultState("1.18.2Fabric", reflectedLocation)) {
                            RegistryEntryReferences.registryEntryWood(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop, Blocks.OAK_PLANKS.defaultBlockState()), tab, true, isModBaseLoaded);
                        }
                        else if(isBlockSetType(reflectedLocation)) {
                            RegistryEntryReferences.registryEntryWood(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop), tab, true, isModBaseLoaded);
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                RegistryEntryReferences.registryEntryWood(MODID, id, new FenceBlock(prop), tab, true, isModBaseLoaded);
                            } else if (isFenceGate(reflectedLocation)) {
                                RegistryEntryReferences.registryEntryWood(MODID, id, new FenceGateBlock(prop), tab, true, isModBaseLoaded);
                            } else if (isTrapdoor(id)) {
                                RegistryEntryReferences.registryEntryWood(MODID, id, new TrapDoorBlock(prop), tab, true, isModBaseLoaded);
                            } else if (isDoor(id)) {
                                RegistryEntryReferences.registryEntryWood(MODID, id, new DoorBlock(prop), tab, true, isModBaseLoaded);
                            } else {
                                RegistryEntryReferences.registryEntryWood(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop), tab, true, isModBaseLoaded);
                            }
                        }
                    }
                    else {
                        RegistryEntryReferences.registryEntryWood(MODID, id, new Block(prop), tab, false, isModBaseLoaded);
                    }
                }
            }
        }
    }

    public static void setRegistriesLeave(String MODID, Map<String, SoundType> stringSoundTypeMap, CreativeModeTab tab)
    {
        setRegistriesLeave(MODID, stringSoundTypeMap, AddonsLib.MODID, tab);
    }

    public static void setRegistriesLeave(String MODID, List<String> list, CreativeModeTab tab)
    {
        setRegistriesLeave(MODID, RegistryUtils.makeDefaultFromList(list, SoundType.GRASS), AddonsLib.MODID, tab);
    }

    public static void setRegistriesLeave(String MODID, List<String> list, String modLoadedTab, CreativeModeTab tab)
    {
        setRegistriesLeave(MODID, RegistryUtils.makeDefaultFromList(list, SoundType.GRASS), modLoadedTab, tab);
    }

    public static void setRegistriesLeave(String MODID, Map<String, SoundType> stringSoundTypeMap, String modLoadedTab, CreativeModeTab tab)
    {
        FabricLoader modList = FabricLoader.getInstance();
        boolean isModBaseLoaded = modList.isModLoaded(modLoadedTab);
        Map<String, SoundType> orderedMap = new LinkedHashMap<>(stringSoundTypeMap);

        McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            for(Map.Entry<String, SoundType> map : orderedMap.entrySet())
            {
                String mat = map.getKey();
                SoundType soundType = map.getValue();

                String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                BlockBehaviour.Properties prop;
                boolean isModLoaded = modList.isModLoaded(mcwBlockIdBase.modid());

                prop = McwProperties.getLeaveProperties().sound(soundType);

                if(isModLoaded)
                {
                    RegistryEntryReferences.registryEntryWood(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop), tab, true, isModBaseLoaded);
                }
                else {
                    RegistryEntryReferences.registryEntryWood(MODID, id, new FenceBlock(prop), tab, false, isModBaseLoaded);
                }
            }
        }
    }

    public static void setRegistriesStone(String MODID, Map<String, SoundType> stringSoundTypeMap, CreativeModeTab tab, ModType... type)
    {
        setRegistriesStone(MODID, stringSoundTypeMap, AddonsLib.MODID, tab, type);
    }

    public static void setRegistriesStone(String MODID, List<String> list, String modLoadedTab, CreativeModeTab tab, ModType... type)
    {
        setRegistriesStone(MODID, RegistryUtils.makeDefaultFromList(list, SoundType.STONE), modLoadedTab, tab, type);
    }

    public static void setRegistriesStone(String MODID, List<String> list, CreativeModeTab tab, ModType... type)
    {
        setRegistriesStone(MODID, RegistryUtils.makeDefaultFromList(list, SoundType.STONE), AddonsLib.MODID, tab, type);
    }

    public static void setRegistriesStone(String MODID, Map<String, SoundType> stringSoundTypeMap, String modLoadedTab, CreativeModeTab tab, ModType... type)
    {
        FabricLoader modList = FabricLoader.getInstance();
        boolean isModBaseLoaded = modList.isModLoaded(modLoadedTab);
        Map<String, SoundType> orderedMap = new LinkedHashMap<>(stringSoundTypeMap);

        for(ModType mod : type)
        {
            for(Map.Entry<String, SoundType> map : orderedMap.entrySet())
            {
                String mat = map.getKey();
                SoundType soundType = map.getValue();

                McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidStone(mod);
                for(BlockId blockId : mcwBlockIdBase.blocks())
                {
                    String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                    String reflectedLocation = blockId.reflectedLocation().getFabric();
                    BlockBehaviour.Properties prop;
                    boolean isModLoaded = modList.isModLoaded(mcwBlockIdBase.modid());

                    prop = McwProperties.getStoneProperties(mod).sound(soundType);

                    if(isModLoaded)
                    {
                        if(isBlockDefaultState("1.18.2Fabric", reflectedLocation)) {
                            RegistryEntryReferences.registryEntryStone(MODID, id,  Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop, Blocks.STONE.defaultBlockState()), tab, true, isModBaseLoaded);
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                RegistryEntryReferences.registryEntryStone(MODID, id,  new FenceBlock(prop), tab, true, isModBaseLoaded);
                            } else if (isFenceGate(reflectedLocation)) {
                                RegistryEntryReferences.registryEntryStone(MODID, id,  new FenceGateBlock(prop), tab, true, isModBaseLoaded);
                            }  else {
                                RegistryEntryReferences.registryEntryStone(MODID, id,  Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop), tab, true, isModBaseLoaded);
                            }
                        }
                    }
                    else {
                        RegistryEntryReferences.registryEntryStone(MODID, id,  new Block(prop), tab, false, isModBaseLoaded);
                    }
                }
            }
        }
    }

}
