package fr.samlegamer.addonslib.registry;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static fr.addonslib.api.registry.ConditionalsRegistry.*;
import static fr.samlegamer.addonslib.registry.RegistryUtils.*;

/*
 * Registry helper for MCW based mods
 */
public final class McwRegistry
{
    private McwRegistry() {}

    public static void setRegistriesWood(String MODID, List<String> list, ModType... type)
    {
        setRegistriesWood(MODID, makeDefaultFromList(list, SoundType.WOOD), type);
    }

    public static void setRegistriesWood(String MODID, Map<String, SoundType> stringSoundTypeMap, ModType... type)
    {
        FabricLoader modList = FabricLoader.getInstance();
        Map<String, SoundType> orderedMap = new LinkedHashMap<>(stringSoundTypeMap);

        for(ModType mod : type)
        {
            for(Map.Entry<String, SoundType> map : orderedMap.entrySet())
            {
                String mat = map.getKey();
                SoundType soundType = map.getValue();
                BlockSetType blockSetType = getBlockSetType(soundType);
                WoodType woodType = getWoodType(soundType);

                McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidWood(mod);
                for(BlockId blockId : mcwBlockIdBase.blocks())
                {
                    String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                    String reflectedLocation = blockId.reflectedLocation().getFabric();
                    BlockBehaviour.Properties prop = McwProperties.getWoodProperties(mat, mod).sound(soundType).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, id)));
                    boolean isModLoaded = modList.isModLoaded(mcwBlockIdBase.modid());


                    if(isModLoaded)
                    {
                        if(isBlockDefaultState("1.18.2Fabric", reflectedLocation)) {
                            RegistryEntryReferences.registryEntryWood(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop, Blocks.OAK_PLANKS.defaultBlockState()));
                        }
                        else if(isBlockSetType(reflectedLocation)) {
                            RegistryEntryReferences.registryEntryWood(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop, blockSetType));
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                RegistryEntryReferences.registryEntryWood(MODID, id, new FenceBlock(prop));
                            } else if (isFenceGate(reflectedLocation)) {
                                RegistryEntryReferences.registryEntryWood(MODID, id, new FenceGateBlock(woodType, prop));
                            } else if (isTrapdoor(id)) {
                                RegistryEntryReferences.registryEntryWood(MODID, id, new TrapDoorBlock(blockSetType, prop));
                            } else if (isDoor(id)) {
                                RegistryEntryReferences.registryEntryWood(MODID, id, new DoorBlock(blockSetType, prop));
                            } else {
                                RegistryEntryReferences.registryEntryWood(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop));
                            }
                        }
                    }
                    else {
                        RegistryEntryReferences.registryEntryWood(MODID, id, new Block(prop));
                    }
                }
            }
        }
    }

    public static void setRegistriesLeave(String MODID, List<String> list)
    {
        setRegistriesLeave(MODID, makeDefaultFromList(list, SoundType.GRASS));
    }

    public static void setRegistriesLeave(String MODID, Map<String, SoundType> stringSoundTypeMap)
    {
        FabricLoader modList = FabricLoader.getInstance();
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

                prop = McwProperties.getLeaveProperties().sound(soundType).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, id)));

                if(isModLoaded)
                {
                    RegistryEntryReferences.registryEntryWood(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop));
                }
                else {
                    RegistryEntryReferences.registryEntryWood(MODID, id, new FenceBlock(prop));
                }
            }
        }
    }

    public static void setRegistriesStone(String MODID, List<String> list, ModType... type)
    {
        setRegistriesStone(MODID, makeDefaultFromList(list, SoundType.STONE), type);
    }

    public static void setRegistriesStone(String MODID, Map<String, SoundType> stringSoundTypeMap, ModType... type)
    {
        FabricLoader modList = FabricLoader.getInstance();
        Map<String, SoundType> orderedMap = new LinkedHashMap<>(stringSoundTypeMap);

        for(ModType mod : type)
        {
            for(Map.Entry<String, SoundType> map : orderedMap.entrySet())
            {
                String mat = map.getKey();
                SoundType soundType = map.getValue();
                WoodType woodType = getWoodType(soundType);

                McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidStone(mod);
                for(BlockId blockId : mcwBlockIdBase.blocks())
                {
                    String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                    String reflectedLocation = blockId.reflectedLocation().getFabric();
                    BlockBehaviour.Properties prop;
                    boolean isModLoaded = modList.isModLoaded(mcwBlockIdBase.modid());

                    prop = McwProperties.getStoneProperties(mod).sound(soundType).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, id)));

                    if(isModLoaded)
                    {
                        if(isBlockDefaultState("1.18.2Fabric", reflectedLocation)) {
                            RegistryEntryReferences.registryEntryStone(MODID, id,  Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop, Blocks.STONE.defaultBlockState()));
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                RegistryEntryReferences.registryEntryWood(MODID, id,  new FenceBlock(prop));
                            } else if (isFenceGate(reflectedLocation)) {
                                RegistryEntryReferences.registryEntryWood(MODID, id,  new FenceGateBlock(woodType, prop));
                            }  else {
                                RegistryEntryReferences.registryEntryWood(MODID, id,  Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop));
                            }
                        }
                    }
                    else {
                        RegistryEntryReferences.registryEntryWood(MODID, id,  new Block(prop));
                    }
                }
            }
        }
    }
}
