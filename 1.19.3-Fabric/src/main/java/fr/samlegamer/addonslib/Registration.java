package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import fr.samlegamer.addonslib.data.ModType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundEvent;

/**
 * Used for easy registries
 */
public final class Registration
{
    private Registration() {}

    public static ModType[] getAllModTypeWood()
    {
        return new ModType[] {ModType.BRIDGES, ModType.ROOFS, ModType.FENCES, ModType.FURNITURES,
                ModType.STAIRS, ModType.PATHS, ModType.TRAPDOORS, ModType.DOORS, ModType.WINDOWS};
    }

    public static ModType[] getAllModTypeStone()
    {
        return new ModType[] {ModType.ROOFS, ModType.FENCES, ModType.BRIDGES};
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

    public static Block getBlocksField(String path, AbstractBlock.Settings WOOD, SoundEvent closeSound, SoundEvent openSound)
    {
        return getField(path, WOOD, new Class<?>[] {AbstractBlock.Settings.class, SoundEvent.class, SoundEvent.class}, WOOD, closeSound, openSound);
    }

    public static Block getBlocksField(String path, AbstractBlock.Settings WOOD, BlockState state)
    {
        return getField(path, WOOD, new Class<?>[] {BlockState.class, AbstractBlock.Settings.class}, state, WOOD);
    }
}