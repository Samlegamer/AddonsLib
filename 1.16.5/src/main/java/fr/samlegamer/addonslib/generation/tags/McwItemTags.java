package fr.samlegamer.addonslib.generation.tags;

import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.ModType;
import fr.addonslib.api.obj.DoubleObject;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import javax.annotation.Nullable;
import java.util.*;

/**
 * Provider Forge pour la génération des tags d'items MCW
 * Utilise TagsUtils (classe commune multiloader) pour la logique
 */
public abstract class McwItemTags extends ItemTagsProvider implements ITag
{
    public McwItemTags(DataGenerator p_i232552_1_, BlockTagsProvider p_i232552_2_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_i232552_1_, p_i232552_2_, modId, existingFileHelper);
    }

    @Override
    public void buildToTagSystem(McwBlockIdBase mcwBlockIdBase, String modid, List<String> MAT)
    {
        Map<DoubleObject<String, String>, String> tags = TagsUtils.makeTags(mcwBlockIdBase, modid, MAT, false);

        for(Map.Entry<DoubleObject<String, String>, String> entry : tags.entrySet())
        {
            Block block = Finder.findBlock(entry.getKey().getFirst(), entry.getKey().getSecond());
            String tagName = entry.getValue();

            if(tagName != null && !tagName.isEmpty() && block != Blocks.AIR)
            {
                this.tag(getTag(tagName)).add(block.asItem());
            }
        }
    }

    @Override
    public void addAllMcwTagsWood(String modid, List<String> WOOD, ModType... types) {
        ITag.super.addAllMcwTagsWood(modid, WOOD, types);
    }

    @Override
    public void addAllMcwTagsLeave(String modid, List<String> WOOD) {
        ITag.super.addAllMcwTagsLeave(modid, WOOD);
    }

    @Override
    public void addAllMcwTagsStone(String modid, List<String> STONE, ModType... types) {
        ITag.super.addAllMcwTagsStone(modid, STONE, types);
    }

    /**
     * Crée une TagKey pour un item à partir d'un nom de tag
     * @param modidTagName Nom du tag au format "namespace:path" (ex: "minecraft:wooden_doors")
     * @return TagKey pour l'item
     */
    public static net.minecraft.tags.ITag.INamedTag<Item> getTag(String modidTagName)
    {
        return ItemTags.bind(modidTagName);
    }
}