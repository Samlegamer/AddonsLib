package fr.samlegamer.addonslib.tab;

import fr.addonslib.api.data.ModType;
import fr.samlegamer.addonslib.util.ModListFabric;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

public class APICreativeTab
{
    public static CreativeModeTab initGroup(String MODID, Supplier<ItemStack> stack)
    {
        return FabricItemGroup.builder()
                .icon(stack)
                .title(Component.translatable(MODID+".tab"))
                .build();
    }

    public static void registerGroup(String MODID, CreativeModeTab tab)
    {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(MODID + ".tab"), tab);
    }

    public static void initAllWood(String MODID, List<String> WOOD, CreativeModeTab tab, String modLoaded, ModType... type)
    {
        Set<ItemStack> blockSet = CreativeTabUtils.getWoodItemForCreativeTab(new ModListFabric(), MODID, WOOD, modLoaded, type);
        ResourceKey<CreativeModeTab> key = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Objects.requireNonNull(BuiltInRegistries.CREATIVE_MODE_TAB.getKey(tab)));

        ItemGroupEvents.modifyEntriesEvent(key).register(content -> {
            for(ItemStack block : blockSet) {
                content.accept(block);
            }
        });
    }

    public static void initAllLeave(String MODID, List<String> LEAVE, CreativeModeTab tab)
    {
        initAllLeave(MODID, LEAVE, tab, "minecraft");
    }

    public static void initAllLeave(String MODID, List<String> LEAVE, CreativeModeTab tab, String modLoaded)
    {
        Set<ItemStack> blockSet = CreativeTabUtils.getHedgeItemForCreativeTab(new ModListFabric(), MODID, LEAVE, modLoaded);
        ResourceKey<CreativeModeTab> key = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Objects.requireNonNull(BuiltInRegistries.CREATIVE_MODE_TAB.getKey(tab)));

        ItemGroupEvents.modifyEntriesEvent(key).register(content -> {
            for(ItemStack block : blockSet) {
                content.accept(block);
            }
        });
    }

    public static void initAllStone(String MODID, List<String> STONE, CreativeModeTab tab, ModType... type)
    {
        initAllStone(MODID, STONE, tab, "minecraft", type);
    }

    public static void initAllStone(String MODID, List<String> STONE, CreativeModeTab tab, String modLoaded, ModType... type)
    {
        Set<ItemStack> blockSet = CreativeTabUtils.getStoneItemForCreativeTab(new ModListFabric(), MODID, STONE, modLoaded, type);
        ResourceKey<CreativeModeTab> key = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Objects.requireNonNull(BuiltInRegistries.CREATIVE_MODE_TAB.getKey(tab)));

        ItemGroupEvents.modifyEntriesEvent(key).register(content -> {
            for(ItemStack block : blockSet) {
                content.accept(block);
            }
        });
    }
}
