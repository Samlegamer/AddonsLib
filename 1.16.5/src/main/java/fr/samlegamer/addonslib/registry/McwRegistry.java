package fr.samlegamer.addonslib.registry;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
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

    public static void setRegistriesWood(List<String> list, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, ModType... type)
    {
        setRegistriesWood(makeDefaultFromList(list, SoundType.WOOD), block, item, tab, type);
    }

    public static void setRegistriesWood(Map<String, SoundType> stringSoundTypeMap, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, ModType... type)
    {
        setRegistriesWood(stringSoundTypeMap, block, item, AddonsLib.MODID, tab, type);
    }

    public static void setRegistriesWood(List<String> list, DeferredRegister<Block> block, DeferredRegister<Item> item, String modLoadedTab, ItemGroup tab, ModType... type)
    {
        setRegistriesWood(makeDefaultFromList(list, SoundType.WOOD), block, item, modLoadedTab, tab, type);
    }

    public static void setRegistriesWood(Map<String, SoundType> stringSoundTypeMap, DeferredRegister<Block> block, DeferredRegister<Item> item, String modLoadedTab, ItemGroup tab, ModType... type)
    {
        ModList modList = ModList.get();
        boolean isModBaseLoaded = ModList.get().isLoaded(modLoadedTab);
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
                    String reflectedLocation = blockId.reflectedLocation().getForge();
                    AbstractBlock.Properties prop;
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
                        if(isBlockDefaultState(reflectedLocation)) {
                            CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, true, isModBaseLoaded);
                        }
                        else if(isBlockSetType(reflectedLocation)) {
                            CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), block, item, tab, true, isModBaseLoaded);
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                CreateBlockReferences.createBlock(id, () -> new FenceBlock(prop), block, item, tab, true, isModBaseLoaded);
                            } else if (isFenceGate(reflectedLocation)) {
                                CreateBlockReferences.createBlock(id, () -> new FenceGateBlock(prop), block, item, tab, true, isModBaseLoaded);
                            } else if (isTrapdoor(id)) {
                                CreateBlockReferences.createBlock(id, () -> new TrapDoorBlock(prop), block, item, tab, true, isModBaseLoaded);
                            } else if (isDoor(id)) {
                                CreateBlockReferences.createBlock(id, () -> new DoorBlock(prop), block, item, tab, true, isModBaseLoaded);
                            } else {
                                CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), block, item, tab, true, isModBaseLoaded);
                            }
                        }
                    }
                    else {
                        CreateBlockReferences.createBlock(id, () -> new Block(prop), block, item, tab, false, isModBaseLoaded);
                    }
                }
            }
        }
    }

    public static void setRegistriesLeave(Map<String, SoundType> stringSoundTypeMap, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
    {
        setRegistriesLeave(stringSoundTypeMap, block, item, AddonsLib.MODID, tab);
    }

    public static void setRegistriesLeave(List<String> list, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
    {
        setRegistriesLeave(makeDefaultFromList(list, SoundType.GRASS), block, item, AddonsLib.MODID, tab);
    }

    public static void setRegistriesLeave(List<String> list, DeferredRegister<Block> block, DeferredRegister<Item> item, String modLoadedTab, ItemGroup tab)
    {
        setRegistriesLeave(makeDefaultFromList(list, SoundType.GRASS), block, item, modLoadedTab, tab);
    }

    public static void setRegistriesLeave(Map<String, SoundType> stringSoundTypeMap, DeferredRegister<Block> block, DeferredRegister<Item> item, String modLoadedTab, ItemGroup tab)
    {
        ModList modList = ModList.get();
        boolean isModBaseLoaded = ModList.get().isLoaded(modLoadedTab);
        Map<String, SoundType> orderedMap = new LinkedHashMap<>(stringSoundTypeMap);

        McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            for(Map.Entry<String, SoundType> map : orderedMap.entrySet())
            {
                String mat = map.getKey();
                SoundType soundType = map.getValue();

                String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                AbstractBlock.Properties prop;
                boolean isModLoaded = modList.isLoaded(mcwBlockIdBase.modid());

                prop = McwProperties.getLeaveProperties().sound(soundType);

                if(isModLoaded)
                {
                    CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), block, item, tab, true, isModBaseLoaded);
                }
                else {
                    CreateBlockReferences.createBlock(id, () -> new FenceBlock(prop), block, item, tab, false, isModBaseLoaded);
                }
            }
        }
    }

    public static void setRegistriesStone(Map<String, SoundType> stringSoundTypeMap, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, ModType... type)
    {
        setRegistriesStone(stringSoundTypeMap, block, item, AddonsLib.MODID, tab, type);
    }

    public static void setRegistriesStone(List<String> list, DeferredRegister<Block> block, DeferredRegister<Item> item, String modLoadedTab, ItemGroup tab, ModType... type)
    {
        setRegistriesStone(makeDefaultFromList(list, SoundType.STONE), block, item, modLoadedTab, tab, type);
    }

    public static void setRegistriesStone(List<String> list, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, ModType... type)
    {
        setRegistriesStone(makeDefaultFromList(list, SoundType.STONE), block, item, AddonsLib.MODID, tab, type);
    }

    public static void setRegistriesStone(Map<String, SoundType> stringSoundTypeMap, DeferredRegister<Block> block, DeferredRegister<Item> item, String modLoadedTab, ItemGroup tab, ModType... type)
    {
        ModList modList = ModList.get();
        boolean isModBaseLoaded = ModList.get().isLoaded(modLoadedTab);
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
                    String reflectedLocation = blockId.reflectedLocation().getForge();
                    AbstractBlock.Properties prop;
                    boolean isModLoaded = modList.isLoaded(mcwBlockIdBase.modid());

                    prop = McwProperties.getStoneProperties(mod).sound(soundType);

                    if(isModLoaded)
                    {
                        if(isBlockDefaultState(reflectedLocation)) {
                            CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop, Blocks.STONE.defaultBlockState()), block, item, tab, true, isModBaseLoaded);
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                CreateBlockReferences.createBlockStone(id, () -> new FenceBlock(prop), block, item, tab, true, isModBaseLoaded);
                            } else if (isFenceGate(reflectedLocation)) {
                                CreateBlockReferences.createBlockStone(id, () -> new FenceGateBlock(prop), block, item, tab, true, isModBaseLoaded);
                            }  else {
                                CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), block, item, tab, true, isModBaseLoaded);
                            }
                        }
                    }
                    else {
                        CreateBlockReferences.createBlockStone(id, () -> new Block(prop), block, item, tab, false, isModBaseLoaded);
                    }
                }
            }
        }
    }

    public static void registryEventWood(final RegistryEvent.Register<Block> event, String Modid, List<String> WOOD, ItemGroup tab, ModType... type)
    {
        ModList modList = ModList.get();

        for(ModType mod : type)
        {
            for(String mat : WOOD)
            {
                SoundType soundType = SoundType.WOOD;

                McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidWood(mod);
                for(BlockId blockId : mcwBlockIdBase.blocks())
                {
                    String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                    String reflectedLocation = blockId.reflectedLocation().getForge();
                    AbstractBlock.Properties prop;
                    boolean isModLoaded = modList.isLoaded(mcwBlockIdBase.modid());

                    prop = McwProperties.getWoodProperties(mat, mod).sound(soundType);

                    if(isModLoaded)
                    {
                        if(isBlockDefaultState(reflectedLocation)) {
                            CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop, Blocks.OAK_PLANKS.defaultBlockState()), tab, true);
                        }
                        else if(isBlockSetType(reflectedLocation)) {
                            CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), tab, true);
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                CreateBlockReferences.createBlockWoodOpti(Modid, id, new FenceBlock(prop), tab, true);
                            } else if (isFenceGate(reflectedLocation)) {
                                CreateBlockReferences.createBlockWoodOpti(Modid, id, new FenceGateBlock(prop), tab, true);
                            } else if (isTrapdoor(id)) {
                                CreateBlockReferences.createBlockWoodOpti(Modid, id, new TrapDoorBlock(prop), tab, true);
                            } else if (isDoor(id)) {
                                CreateBlockReferences.createBlockWoodOpti(Modid, id, new DoorBlock(prop), tab, true);
                            } else {
                                CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), tab, true);
                            }
                        }
                    }
                    else {
                        CreateBlockReferences.createBlockWoodOpti(Modid, id, new Block(prop), tab, false);
                    }
                }
            }
        }
    }

    public static void registryEventLeave(final RegistryEvent.Register<Block> event, String Modid, List<String> LEAVE, ItemGroup tab)
    {
        ModList modList = ModList.get();
        McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidLeave(ModType.FENCES);

        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            for(String mat : LEAVE)
            {
                SoundType soundType = SoundType.GRASS;

                String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                AbstractBlock.Properties prop;
                boolean isModLoaded = modList.isLoaded(mcwBlockIdBase.modid());

                prop = McwProperties.getLeaveProperties().sound(soundType);

                if(isModLoaded)
                {
                    CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), tab, true);
                }
                else {
                    CreateBlockReferences.createBlockWoodOpti(Modid, id, new FenceBlock(prop), tab, false);
                }
            }
        }
    }

    public static void registryEventStone(final RegistryEvent.Register<Block> event, String Modid, List<String> STONE, ItemGroup tab, ModType... type)
    {
        ModList modList = ModList.get();

        for(ModType mod : type)
        {
            for(String mat : STONE)
            {
                SoundType soundType = SoundType.STONE;

                McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidStone(mod);
                for(BlockId blockId : mcwBlockIdBase.blocks())
                {
                    String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                    String reflectedLocation = blockId.reflectedLocation().getForge();
                    AbstractBlock.Properties prop;
                    boolean isModLoaded = modList.isLoaded(mcwBlockIdBase.modid());

                    prop = McwProperties.getStoneProperties(mod).sound(soundType);

                    if(isModLoaded)
                    {
                        if(isBlockDefaultState(reflectedLocation)) {
                            CreateBlockReferences.createBlockStoneOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop, Blocks.STONE.defaultBlockState()), tab, true);
                        }
                        else {
                            if (isFence(reflectedLocation)) {
                                CreateBlockReferences.createBlockStoneOpti(Modid, id, new FenceBlock(prop), tab, true);
                            } else if (isFenceGate(reflectedLocation)) {
                                CreateBlockReferences.createBlockStoneOpti(Modid, id, new FenceGateBlock(prop), tab, true);
                            }  else {
                                CreateBlockReferences.createBlockStoneOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation().getForge(), prop), tab, true);
                            }
                        }
                    }
                    else {
                        CreateBlockReferences.createBlockStoneOpti(Modid, id, new Block(prop), tab, false);
                    }
                }
            }
        }
    }
}
