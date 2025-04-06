package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;

/**
 * Used for easy registries
 */
public class Registration
{	
    public static Block getBlocksField(String intermediaryClassName, AbstractBlock.Settings settings) {
        try {
            MappingResolver resolver = FabricLoader.getInstance().getMappingResolver();

            String runtimeClassName = resolver.mapClassName("intermediary", intermediaryClassName);

            Class<?> blockClass = Class.forName(runtimeClassName);

            Constructor<?> constructor = blockClass.getConstructor(AbstractBlock.Settings.class);

            Object blockInstance = constructor.newInstance(settings);

            if (blockInstance instanceof Block) {
                return (Block) blockInstance;
            } else {
                throw new IllegalStateException("La classe " + runtimeClassName + " n'est pas un Block valide.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Classe introuvable : " + intermediaryClassName);
        } catch (NoSuchMethodException e) {
            System.err.println("Constructeur incorrect pour la classe : " + intermediaryClassName);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création du bloc pour : " + intermediaryClassName);
            e.printStackTrace();
        }

        System.err.println("Retour d'un bloc par défaut pour : " + intermediaryClassName);
        return new Block(settings);
    }

    public static Block getBlocksField(String intermediaryClassName, AbstractBlock.Settings settings, BlockSetType blockSetType) {
        try {
            MappingResolver resolver = FabricLoader.getInstance().getMappingResolver();

            String runtimeClassName = resolver.mapClassName("intermediary", intermediaryClassName);

            Class<?> blockClass = Class.forName(runtimeClassName);

            Constructor<?> constructor = blockClass.getConstructor(AbstractBlock.Settings.class, BlockSetType.class);

            Object blockInstance = constructor.newInstance(settings, blockSetType);

            if (blockInstance instanceof Block) {
                return (Block) blockInstance;
            } else {
                throw new IllegalStateException("La classe " + runtimeClassName + " n'est pas un Block valide.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Classe introuvable : " + intermediaryClassName);
        } catch (NoSuchMethodException e) {
            System.err.println("Constructeur incorrect pour la classe : " + intermediaryClassName);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création du bloc pour : " + intermediaryClassName);
            e.printStackTrace();
        }

        System.err.println("Retour d'un bloc par défaut pour : " + intermediaryClassName);
        return new Block(settings);
    }



    public static Block getBlocksField(String intermediaryClassName, AbstractBlock.Settings settings, BlockState defaultState) {
		try {
            MappingResolver resolver = FabricLoader.getInstance().getMappingResolver();

            String runtimeClassName = resolver.mapClassName("intermediary", intermediaryClassName);

            Class<?> blockClass = Class.forName(runtimeClassName);

            Constructor<?> constructor = blockClass.getConstructor(BlockState.class, AbstractBlock.Settings.class);

            Object blockInstance = constructor.newInstance(defaultState, settings);

            if (blockInstance instanceof Block) {
                return (Block) blockInstance;
            } else {
                throw new IllegalStateException("La classe " + runtimeClassName + " n'est pas un Block valide.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Classe introuvable : " + intermediaryClassName);
        } catch (NoSuchMethodException e) {
            System.err.println("Constructeur incorrect pour la classe : " + intermediaryClassName);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création du bloc pour : " + intermediaryClassName);
            e.printStackTrace();
        }

        System.err.println("Retour d'un bloc par défaut pour : " + intermediaryClassName);
        return new Block(settings);
    }

}