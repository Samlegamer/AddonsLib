package fr.addonslib.api.tags;

import java.util.List;

public class Tags
{
    public final List<String> tagsBlock;
    public final List<String> tagsItem;

    public Tags(List<String> tagsBlock, List<String> tagsItem)
    {
        this.tagsBlock = tagsBlock;
        this.tagsItem = tagsItem;
    }

    public boolean hasBlockTags()
    {
        return !tagsBlock.isEmpty();
    }

    public boolean hasItemTags()
    {
        return !tagsItem.isEmpty();
    }

    public List<String> getTagsBlock() {
        return tagsBlock;
    }

    public List<String> getTagsItem() {
        return tagsItem;
    }

    public static String formatTag(String modid, String tag)
    {
        return modid + ":" + tag;
    }
}
