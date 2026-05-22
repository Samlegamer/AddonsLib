package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;

import fr.addonslib.api.data.ModType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;

/**
 * Used for easy registries
 */
public final class Registration
{
    private Registration() {}

    @Deprecated(forRemoval = true)
    public static ModType[] getAllModTypeWood()
    {
        return ModType.getAllModTypeWood();

    }

    @Deprecated(forRemoval = true)
    public static ModType[] getAllModTypeStone()
    {
        return ModType.getAllModTypeStone();
    }

    public static Block getField(String path, AbstractBlock.Settings prop, Class<?>[] params, Object... values)
    {
        try {
            MappingResolver resolver = FabricLoader.getInstance().getMappingResolver();

            String runtimeClassName = resolver.mapClassName("intermediary", path);

            Class<?> blockClass = Class.forName(runtimeClassName);

            Constructor<?> constructor = blockClass.getConstructor(params);

            Object blockInstance = constructor.newInstance(values);

            if (blockInstance instanceof Block) {
                return (Block) blockInstance;
            } else {
                AddonsLib.LOGGER.error("This class is not a Block class : {}", runtimeClassName);
            }
        } catch (ClassNotFoundException e) {
            AddonsLib.LOGGER.error("Class Not Found : {}", path);
        } catch (NoSuchMethodException e) {
            AddonsLib.LOGGER.error("Object Params error for class : {}", path);
        } catch (Exception e) {
            AddonsLib.LOGGER.error("Error with block creation, a default block is returned : {}", path);
        }
        return new Block(prop);
    }

    public static Block getBlocksField(String path, AbstractBlock.Settings WOOD)
    {
        return getField(path, WOOD, new Class<?>[] {AbstractBlock.Settings.class}, WOOD);
    }

    public static Block getBlocksField(String path, AbstractBlock.Settings WOOD, BlockSetType type)
    {
        return getField(path, WOOD, new Class<?>[] {AbstractBlock.Settings.class, BlockSetType.class}, WOOD, type);
    }

    public static Block getBlocksField(String path, AbstractBlock.Settings WOOD, BlockState state)
    {
        return getField(path, WOOD, new Class<?>[] {BlockState.class, AbstractBlock.Settings.class}, state, WOOD);
    }
}