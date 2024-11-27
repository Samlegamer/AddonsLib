package fr.samlegamer.addonslib.mapping;

import net.minecraftforge.registries.MissingMappingsEvent;

/*
 * Used for easy MappingMissing registry
 */
public interface IMappings
{
	void missingnoWoodBlock(MissingMappingsEvent event);
	void missingnoWoodItem(MissingMappingsEvent event);
	void missingnoStoneBlock(MissingMappingsEvent event);
	void missingnoStoneItem(MissingMappingsEvent event);
}
