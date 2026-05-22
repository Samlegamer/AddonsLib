package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

/**
 * Used for easy registries
 */
public final class RegistrationFabric
{
    private RegistrationFabric() {}

    public static Block getField(String path, BlockBehaviour.Properties prop, Class<?>[] params, Object... values)
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

    public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD)
    {
        return getField(path, WOOD, new Class<?>[] {BlockBehaviour.Properties.class}, WOOD);
    }

    public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD, BlockSetType type)
    {
        return getField(path, WOOD, new Class<?>[] {BlockBehaviour.Properties.class, BlockSetType.class}, WOOD, type);
    }

    public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD, BlockState state)
    {
        return getField(path, WOOD, new Class<?>[] {BlockState.class, BlockBehaviour.Properties.class}, state, WOOD);
    }
}