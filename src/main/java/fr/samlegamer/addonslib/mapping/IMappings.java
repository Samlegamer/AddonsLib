package fr.samlegamer.addonslib.mapping;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

/*
 * Used for easy MappingMissing registry
 */
public interface IMappings
{
	void missingnoWoodBlock(RegistryEvent.MissingMappings<Block> event);
	void missingnoWoodItem(RegistryEvent.MissingMappings<Item> event);
	void missingnoStoneBlock(RegistryEvent.MissingMappings<Block> event);
	void missingnoStoneItem(RegistryEvent.MissingMappings<Item> event);
}
