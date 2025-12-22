package fr.addonslib.api.furnitures;

import fr.samlegamer.addonslib.Finder;

import java.util.ArrayList;
import java.util.List;

public final class FurnitureStorageAdd
{
    private FurnitureStorageAdd() {}

    public static List<String> getForge()
    {
        List<String> furniture_storage = new ArrayList<>();
        furniture_storage.add("%material%_wardrobe");
        furniture_storage.add("%material%_modern_wardrobe");
        furniture_storage.add("%material%_double_wardrobe");
        furniture_storage.add("%material%_bookshelf");
        furniture_storage.add("%material%_bookshelf_cupboard");
        furniture_storage.add("%material%_drawer");
        furniture_storage.add("%material%_double_drawer");
        furniture_storage.add("%material%_bookshelf_drawer");
        furniture_storage.add("%material%_lower_bookshelf_drawer");
        furniture_storage.add("%material%_large_drawer");
        furniture_storage.add("%material%_lower_triple_drawer");
        furniture_storage.add("%material%_triple_drawer");
        furniture_storage.add("%material%_drawer_counter");
        furniture_storage.add("%material%_double_drawer_counter");
        furniture_storage.add("%material%_cupboard_counter");
        furniture_storage.add("stripped_%material%_wardrobe");
        furniture_storage.add("stripped_%material%_modern_wardrobe");
        furniture_storage.add("stripped_%material%_double_wardrobe");
        furniture_storage.add("stripped_%material%_bookshelf");
        furniture_storage.add("stripped_%material%_bookshelf_cupboard");
        furniture_storage.add("stripped_%material%_drawer");
        furniture_storage.add("stripped_%material%_double_drawer");
        furniture_storage.add("stripped_%material%_bookshelf_drawer");
        furniture_storage.add("stripped_%material%_lower_bookshelf_drawer");
        furniture_storage.add("stripped_%material%_large_drawer");
        furniture_storage.add("stripped_%material%_lower_triple_drawer");
        furniture_storage.add("stripped_%material%_triple_drawer");
        furniture_storage.add("stripped_%material%_counter");
        furniture_storage.add("stripped_%material%_drawer_counter");
        furniture_storage.add("stripped_%material%_double_drawer_counter");
        furniture_storage.add("stripped_%material%_cupboard_counter");
        furniture_storage.add("%material%_kitchen_cabinet");
        furniture_storage.add("%material%_double_kitchen_cabinet");
        furniture_storage.add("%material%_glass_kitchen_cabinet");
        furniture_storage.add("stripped_%material%_kitchen_cabinet");
        furniture_storage.add("stripped_%material%_double_kitchen_cabinet");
        furniture_storage.add("stripped_%material%_glass_kitchen_cabinet");
        return furniture_storage;
    }

    public static List<String> getFabric()
    {
        List<String> furniture_storage = getForge();
        furniture_storage.add("%material%_counter");
        furniture_storage.add("stripped_%material%_counter");
        return furniture_storage;
    }
}