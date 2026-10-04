package fr.samlegamer.addonslib.mapping;

import net.neoforged.neoforge.registries.DeferredRegister;

/*
 * Used for easy MappingMissing registry
 */
public interface IMappings
{
	void missingnoWoodBlock(DeferredRegister.Blocks blocks);
	void missingnoWoodItem(DeferredRegister.Items items);
	void missingnoStoneBlock(DeferredRegister.Blocks blocks);
	void missingnoStoneItem(DeferredRegister.Items items);
}
