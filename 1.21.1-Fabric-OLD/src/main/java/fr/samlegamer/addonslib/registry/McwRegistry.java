package fr.samlegamer.addonslib.registry;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
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

    public static Map<String, BlockSoundGroup> makeDefaultFromList(List<String> list, BlockSoundGroup soundType)
    {
        Map<String, BlockSoundGroup> map = new LinkedHashMap<>();

        for(String str : list)
        {
            map.put(str, soundType);
        }

        return map;
    }

    public static void setRegistriesWood(String MODID, List<String> list, ModType... type)
    {
        setRegistriesWood(MODID, makeDefaultFromList(list, BlockSoundGroup.WOOD), type);
    }

    public static void setRegistriesWood(String MODID, Map<String, BlockSoundGroup> stringSoundTypeMap, ModType... type)
    {
        FabricLoader modList = FabricLoader.getInstance();
        Map<String, BlockSoundGroup> orderedMap = new LinkedHashMap<>(stringSoundTypeMap);

        for(ModType mod : type)
        {
            for(Map.Entry<String, BlockSoundGroup> map : orderedMap.entrySet())
            {
                String mat = map.getKey();
                BlockSoundGroup soundType = map.getValue();
                BlockSetType blockSetType = getBlockSetType(soundType);
                WoodType woodType = getWoodType(soundType);

                McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidWood(mod);
                for(BlockId blockId : mcwBlockIdBase.blocks())
                {
                    String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                    String reflectedLocation = blockId.reflectedLocation().getFabric();
                    AbstractBlock.Settings prop = McwProperties.getWoodProperties(mat, mod).sounds(soundType);;
                    boolean isModLoaded = modList.isModLoaded(mcwBlockIdBase.modid());


                    if(isModLoaded)
                    {
                        if(isBlockDefaultState("1.18.2Fabric", reflectedLocation)) {
                            RegistryEntryReferences.registryEntry(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop, Blocks.OAK_PLANKS.getDefaultState()));
                        }
                        else if(isBlockSetType(reflectedLocation)) {
                            RegistryEntryReferences.registryEntry(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop, blockSetType));
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(prop));
                            } else if (isFenceGate(reflectedLocation)) {
                                RegistryEntryReferences.registryEntry(MODID, id, new FenceGateBlock(woodType, prop));
                            } else if (isTrapdoor(id)) {
                                RegistryEntryReferences.registryEntry(MODID, id, new TrapdoorBlock(blockSetType, prop));
                            } else if (isDoor(id)) {
                                RegistryEntryReferences.registryEntry(MODID, id, new DoorBlock(blockSetType, prop));
                            } else {
                                RegistryEntryReferences.registryEntry(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop));
                            }
                        }
                    }
                    else {
                        RegistryEntryReferences.registryEntry(MODID, id, new Block(prop));
                    }
                }
            }
        }
    }

    public static void setRegistriesLeave(String MODID, List<String> list)
    {
        setRegistriesLeave(MODID, makeDefaultFromList(list, BlockSoundGroup.GRASS));
    }

    public static void setRegistriesLeave(String MODID, Map<String, BlockSoundGroup> stringSoundTypeMap)
    {
        FabricLoader modList = FabricLoader.getInstance();
        Map<String, BlockSoundGroup> orderedMap = new LinkedHashMap<>(stringSoundTypeMap);

        McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            for(Map.Entry<String, BlockSoundGroup> map : orderedMap.entrySet())
            {
                String mat = map.getKey();
                BlockSoundGroup soundType = map.getValue();

                String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                AbstractBlock.Settings prop;
                boolean isModLoaded = modList.isModLoaded(mcwBlockIdBase.modid());

                prop = McwProperties.getLeaveProperties().sounds(soundType);

                if(isModLoaded)
                {
                    RegistryEntryReferences.registryEntry(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop));
                }
                else {
                    RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(prop));
                }
            }
        }
    }

    public static void setRegistriesStone(String MODID, List<String> list, ModType... type)
    {
        setRegistriesStone(MODID, makeDefaultFromList(list, BlockSoundGroup.STONE), type);
    }

    public static void setRegistriesStone(String MODID, Map<String, BlockSoundGroup> stringSoundTypeMap, ModType... type)
    {
        FabricLoader modList = FabricLoader.getInstance();
        Map<String, BlockSoundGroup> orderedMap = new LinkedHashMap<>(stringSoundTypeMap);

        for(ModType mod : type)
        {
            for(Map.Entry<String, BlockSoundGroup> map : orderedMap.entrySet())
            {
                String mat = map.getKey();
                BlockSoundGroup soundType = map.getValue();
                WoodType woodType = getWoodType(soundType);

                McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidStone(mod);
                for(BlockId blockId : mcwBlockIdBase.blocks())
                {
                    String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                    String reflectedLocation = blockId.reflectedLocation().getFabric();
                    AbstractBlock.Settings prop;
                    boolean isModLoaded = modList.isModLoaded(mcwBlockIdBase.modid());

                    prop = McwProperties.getStoneProperties(mod).sounds(soundType);

                    if(isModLoaded)
                    {
                        if(isBlockDefaultState("1.18.2Fabric", reflectedLocation)) {
                            RegistryEntryReferences.registryEntry(MODID, id,  Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop, Blocks.STONE.getDefaultState()));
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                RegistryEntryReferences.registryEntry(MODID, id,  new FenceBlock(prop));
                            } else if (isFenceGate(reflectedLocation)) {
                                RegistryEntryReferences.registryEntry(MODID, id,  new FenceGateBlock(woodType, prop));
                            }  else {
                                RegistryEntryReferences.registryEntry(MODID, id,  Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop));
                            }
                        }
                    }
                    else {
                        RegistryEntryReferences.registryEntry(MODID, id,  new Block(prop));
                    }
                }
            }
        }
    }

    private static BlockSetType getBlockSetType(BlockSoundGroup soundType)
    {
        if(soundType == BlockSoundGroup.CHERRY_WOOD) {
            return BlockSetType.CHERRY;
        }
        else if(soundType == BlockSoundGroup.NETHER_WOOD) {
            return BlockSetType.CRIMSON;
        }
        else if(soundType == BlockSoundGroup.BAMBOO_WOOD) {
            return BlockSetType.BAMBOO;
        }
        else {
            return BlockSetType.OAK;
        }
    }

    private static WoodType getWoodType(BlockSoundGroup soundType)
    {
        if(soundType == BlockSoundGroup.CHERRY_WOOD) {
            return WoodType.CHERRY;
        }
        else if(soundType == BlockSoundGroup.NETHER_WOOD) {
            return WoodType.CRIMSON;
        }
        else if(soundType == BlockSoundGroup.BAMBOO_WOOD) {
            return WoodType.BAMBOO;
        }
        else {
            return WoodType.OAK;
        }
    }
}
