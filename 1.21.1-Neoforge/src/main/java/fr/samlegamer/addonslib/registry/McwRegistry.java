package fr.samlegamer.addonslib.registry;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;
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

    public static Map<String, SoundType> makeDefaultFromList(List<String> list, SoundType soundType)
    {
        Map<String, SoundType> map = new LinkedHashMap<>();

        for(String str : list)
        {
            map.put(str, soundType);
        }

        return map;
    }

    public static void setRegistriesWood(List<String> list, DeferredRegister.Blocks block, DeferredRegister.Items item, ModType... type)
    {
        setRegistriesWood(makeDefaultFromList(list, SoundType.WOOD), block, item, type);
    }

    public static void setRegistriesWood(Map<String, SoundType> stringSoundTypeMap, DeferredRegister.Blocks block, DeferredRegister.Items item, ModType... type)
    {
        ModList modList = ModList.get();
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
                    String reflectedLocation = blockId.reflectedLocation().getForge();
                    BlockBehaviour.Properties prop;
                    boolean isModLoaded = modList.isLoaded(mcwBlockIdBase.modid());

                    if(soundType == SoundType.GLASS)
                    {
                        prop = McwProperties.getWoodProperties(mat, mod).noOcclusion().sound(soundType);
                    }
                    else {
                        prop = McwProperties.getWoodProperties(mat, mod).sound(soundType);
                    }

                    if(isModLoaded)
                    {
                        if(isBlockDefaultState("1.17.1", reflectedLocation)) {
                            CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
                        }
                        else if(isBlockSetType(reflectedLocation)) {
                            CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop, blockSetType), block, item);
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                CreateBlockReferences.createBlock(id, () -> new FenceBlock(prop), block, item);
                            } else if (isFenceGate(reflectedLocation)) {
                                CreateBlockReferences.createBlock(id, () -> new FenceGateBlock(woodType, prop), block, item);
                            } else if (isTrapdoor(id)) {
                                CreateBlockReferences.createBlock(id, () -> new TrapDoorBlock(blockSetType, prop), block, item);
                            } else if (isDoor(id)) {
                                CreateBlockReferences.createBlock(id, () -> new DoorBlock(blockSetType, prop), block, item);
                            } else {
                                CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), block, item);
                            }
                        }
                    }
                    else {
                        CreateBlockReferences.createBlock(id, () -> new Block(prop), block, item);
                    }
                }
            }
        }
    }

    public static void setRegistriesLeave(List<String> list, DeferredRegister.Blocks block, DeferredRegister.Items item)
    {
        setRegistriesLeave(makeDefaultFromList(list, SoundType.GRASS), block, item);
    }

    public static void setRegistriesLeave(Map<String, SoundType> stringSoundTypeMap, DeferredRegister.Blocks block, DeferredRegister.Items item)
    {
        ModList modList = ModList.get();
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
                boolean isModLoaded = modList.isLoaded(mcwBlockIdBase.modid());

                prop = McwProperties.getLeaveProperties().sound(soundType);

                if(isModLoaded)
                {
                    CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), block, item);
                }
                else {
                    CreateBlockReferences.createBlock(id, () -> new FenceBlock(prop), block, item);
                }
            }
        }
    }

    public static void setRegistriesStone(List<String> list, DeferredRegister.Blocks block, DeferredRegister.Items item, ModType... type)
    {
        setRegistriesStone(makeDefaultFromList(list, SoundType.STONE), block, item, type);
    }

    public static void setRegistriesStone(Map<String, SoundType> stringSoundTypeMap, DeferredRegister.Blocks block, DeferredRegister.Items item, ModType... type)
    {
        ModList modList = ModList.get();
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
                    String reflectedLocation = blockId.reflectedLocation().getForge();
                    BlockBehaviour.Properties prop;
                    boolean isModLoaded = modList.isLoaded(mcwBlockIdBase.modid());

                    prop = McwProperties.getStoneProperties(mod).sound(soundType);

                    if(isModLoaded)
                    {
                        if(isBlockDefaultState("1.17.1", reflectedLocation)) {
                            CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop, Blocks.STONE.defaultBlockState()), block, item);
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                CreateBlockReferences.createBlockStone(id, () -> new FenceBlock(prop), block, item);
                            } else if (isFenceGate(reflectedLocation)) {
                                CreateBlockReferences.createBlockStone(id, () -> new FenceGateBlock(woodType, prop), block, item);
                            }  else {
                                CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), block, item);
                            }
                        }
                    }
                    else {
                        CreateBlockReferences.createBlockStone(id, () -> new Block(prop), block, item);
                    }
                }
            }
        }
    }

    private static BlockSetType getBlockSetType(SoundType soundType)
    {
        if(soundType == SoundType.CHERRY_WOOD) {
            return BlockSetType.CHERRY;
        }
        else if(soundType == SoundType.NETHER_WOOD) {
            return BlockSetType.CRIMSON;
        }
        else if(soundType == SoundType.BAMBOO_WOOD) {
            return BlockSetType.BAMBOO;
        }
        else {
            return BlockSetType.OAK;
        }
    }

    private static WoodType getWoodType(SoundType soundType)
    {
        if(soundType == SoundType.CHERRY_WOOD) {
            return WoodType.CHERRY;
        }
        else if(soundType == SoundType.NETHER_WOOD) {
            return WoodType.CRIMSON;
        }
        else if(soundType == SoundType.BAMBOO_WOOD) {
            return WoodType.BAMBOO;
        }
        else {
            return WoodType.OAK;
        }
    }
}
