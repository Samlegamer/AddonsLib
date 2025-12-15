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
import net.minecraft.sound.SoundEvents;
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
                            RegistryEntryReferences.registryEntry(MODID, id, Registration.getBlocksField(blockId.reflectedLocation().getFabric(), prop, SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(prop));
                            } else if (isFenceGate(reflectedLocation)) {
                                RegistryEntryReferences.registryEntry(MODID, id, new FenceGateBlock(prop, SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN));
                            } else if (isTrapdoor(id)) {
                                RegistryEntryReferences.registryEntry(MODID, id, new TrapdoorBlock(prop, SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN));
                            } else if (isDoor(id)) {
                                RegistryEntryReferences.registryEntry(MODID, id, new DoorBlock(prop, SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
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
                                RegistryEntryReferences.registryEntry(MODID, id,  new FenceGateBlock(prop, SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN));
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
}
