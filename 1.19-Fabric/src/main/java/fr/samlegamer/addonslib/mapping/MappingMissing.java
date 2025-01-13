package fr.samlegamer.addonslib.mapping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Converts your old block compat with the new registry
 * First used with McwBridgesAbnormals
 * Warning for convert long compatibility use changeOldModid
 */
public class MappingMissing
{	
	public static class Furnitures
	{
		protected String oldModid;
		protected String newModid;
		protected List<String> mats;

		public Furnitures(String oldModid, String newModid, List<String> mats)
		{
			this.oldModid = oldModid;
			this.newModid = newModid;
			this.mats = mats;
		}
		
		public void missingnoWoodBlock()
		{
			for(String i : this.mats)
			{
				addMissingBlock(oldModid, newModid, i+"_wardrobe", i+"_wardrobe");
				addMissingBlock(oldModid, newModid, i+"_modern_wardrobe", i+"_modern_wardrobe");
				addMissingBlock(oldModid, newModid, i+"_double_wardrobe", i+"_double_wardrobe");
				addMissingBlock(oldModid, newModid, i+"_bookshelf", i+"_bookshelf");
				addMissingBlock(oldModid, newModid, i+"_bookshelf_cupboard", i+"_bookshelf_cupboard");
				addMissingBlock(oldModid, newModid, i+"_drawer", i+"_drawer");
				addMissingBlock(oldModid, newModid, i+"_double_drawer", i+"_double_drawer");
				addMissingBlock(oldModid, newModid, i+"_bookshelf_drawer", i+"_bookshelf_drawer");
				addMissingBlock(oldModid, newModid, i+"_lower_bookshelf_drawer", i+"_lower_bookshelf_drawer");
				addMissingBlock(oldModid, newModid, i+"_large_drawer", i+"_large_drawer");
				addMissingBlock(oldModid, newModid, i+"_lower_triple_drawer", i+"_lower_triple_drawer");
				addMissingBlock(oldModid, newModid, i+"_triple_drawer", i+"_triple_drawer");
				addMissingBlock(oldModid, newModid, i+"_desk", i+"_desk");
				addMissingBlock(oldModid, newModid, i+"_covered_desk", i+"_covered_desk");
				addMissingBlock(oldModid, newModid, i+"_modern_desk", i+"_modern_desk");
				addMissingBlock(oldModid, newModid, i+"_table", i+"_table");
				addMissingBlock(oldModid, newModid, i+"_end_table", i+"_end_table");
				addMissingBlock(oldModid, newModid, i+"_coffee_table", i+"_coffee_table");
				addMissingBlock(oldModid, newModid, i+"_glass_table", i+"_glass_table");
				addMissingBlock(oldModid, newModid, i+"_chair", i+"_chair");
				addMissingBlock(oldModid, newModid, i+"_modern_chair", i+"_modern_chair");
				addMissingBlock(oldModid, newModid, i+"_striped_chair", i+"_striped_chair");
				addMissingBlock(oldModid, newModid, i+"_stool_chair", i+"_stool_chair");
				addMissingBlock(oldModid, newModid, i+"_counter", i+"_counter");
				addMissingBlock(oldModid, newModid, i+"_drawer_counter", i+"_drawer_counter");
				addMissingBlock(oldModid, newModid, i+"_double_drawer_counter", i+"_double_drawer_counter");
				addMissingBlock(oldModid, newModid, i+"_cupboard_counter", i+"_cupboard_counter");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_wardrobe", "stripped_"+i+"_wardrobe");
				
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_modern_wardrobe", "stripped_"+i+"_modern_wardrobe");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_double_wardrobe", "stripped_"+i+"_double_wardrobe");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_bookshelf", "stripped_"+i+"_bookshelf");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_bookshelf_cupboard", "stripped_"+i+"_bookshelf_cupboard");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_drawer", "stripped_"+i+"_drawer");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_double_drawer", "stripped_"+i+"_double_drawer");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_bookshelf_drawer", "stripped_"+i+"_bookshelf_drawer");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_lower_bookshelf_drawer", "stripped_"+i+"_lower_bookshelf_drawer");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_large_drawer", "stripped_"+i+"_large_drawer");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_lower_triple_drawer", "stripped_"+i+"_lower_triple_drawer");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_triple_drawer", "stripped_"+i+"_triple_drawer");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_desk", "stripped_"+i+"_desk");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_covered_desk", "stripped_"+i+"_covered_desk");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_modern_desk", "stripped_"+i+"_modern_desk");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_table", "stripped_"+i+"_table");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_end_table", "stripped_"+i+"_end_table");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_coffee_table", "stripped_"+i+"_coffee_table");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_glass_table", "stripped_"+i+"_glass_table");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_chair", "stripped_"+i+"_chair");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_modern_chair", "stripped_"+i+"_modern_chair");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_striped_chair", "stripped_"+i+"_striped_chair");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_stool_chair", "stripped_"+i+"_stool_chair");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_counter", "stripped_"+i+"_counter");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_drawer_counter", "stripped_"+i+"_drawer_counter");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_double_drawer_counter", "stripped_"+i+"_double_drawer_counter");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_cupboard_counter", "stripped_"+i+"_cupboard_counter");
				addMissingBlock(oldModid, newModid, i+"_kitchen_cabinet", i+"_kitchen_cabinet");
				addMissingBlock(oldModid, newModid, i+"_double_kitchen_cabinet", i+"_double_kitchen_cabinet");
				addMissingBlock(oldModid, newModid, i+"_glass_kitchen_cabinet", i+"_glass_kitchen_cabinet");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_kitchen_cabinet", "stripped_"+i+"_kitchen_cabinet");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_double_kitchen_cabinet", "stripped_"+i+"_double_kitchen_cabinet");
				addMissingBlock(oldModid, newModid, "stripped_"+i+"_glass_kitchen_cabinet", "stripped_"+i+"_glass_kitchen_cabinet");
			}
		}
	}
	
	public static class Roofs
	{
		protected String oldModid;
		protected String newModid;
		protected List<String> mats;
		protected List<String> mat_rockable;
		protected List<String> leaves;

		public Roofs(String oldModid, String newModid, List<String> mats)
		{
			this.oldModid = oldModid;
			this.newModid = newModid;
			this.mats = mats;
		}
		
		public Roofs(String oldModid, String newModid, List<String> mats_wooden, List<String> mat_rockable)
		{
			this(oldModid, newModid, mats_wooden);
			this.mat_rockable  = mat_rockable;
		}
		
		public void missingnoWoodBlock()
		{
			for(String i : this.mats)
			{
				addMissingBlock(oldModid, newModid, i+"_roof", i+"_roof");
				addMissingBlock(oldModid, newModid, i+"_attic_roof", i+"_attic_roof");
				addMissingBlock(oldModid, newModid, i+"_top_roof", i+"_top_roof");
				addMissingBlock(oldModid, newModid, i+"_lower_roof", i+"_lower_roof");
				addMissingBlock(oldModid, newModid, i+"_steep_roof", i+"_steep_roof");
				addMissingBlock(oldModid, newModid, i+"_upper_lower_roof", i+"_upper_lower_roof");
				addMissingBlock(oldModid, newModid, i+"_upper_steep_roof", i+"_upper_steep_roof");

				addMissingBlock(oldModid, newModid, i+"_planks_roof", i+"_planks_roof");
				addMissingBlock(oldModid, newModid, i+"_planks_attic_roof", i+"_planks_attic_roof");
				addMissingBlock(oldModid, newModid, i+"_planks_top_roof", i+"_planks_top_roof");
				addMissingBlock(oldModid, newModid, i+"_planks_lower_roof", i+"_planks_lower_roof");
				addMissingBlock(oldModid, newModid, i+"_planks_steep_roof", i+"_planks_steep_roof");
				addMissingBlock(oldModid, newModid, i+"_planks_upper_lower_roof", i+"_planks_upper_lower_roof");
				addMissingBlock(oldModid, newModid, i+"_planks_upper_steep_roof", i+"_planks_upper_steep_roof");
			}
		}
	}

	public static class Fences
	{
		protected String oldModid;
		protected String newModid;
		protected List<String> mats;
		protected List<String> mat_rockable;
		protected List<String> leaves;
		protected boolean Hedges = false;

		public Fences(String oldModid, String newModid, List<String> mats)
		{
			this.oldModid = oldModid;
			this.newModid = newModid;
			this.mats = mats;
		}
		
		public Fences(String oldModid, String newModid, List<String> mats_wooden, List<String> mat_rockable)
		{
			this(oldModid, newModid, mats_wooden);
			this.mat_rockable  = mat_rockable;
		}
		
		/**
		 * Activate Leaves to Mapping Wood
		 */
		public void leavesAdding(List<String> leaves)
		{
			this.Hedges = true;
			this.leaves  = leaves;
		}

		public void missingnoWoodBlock()
		{		
			for(String i : this.mats)
			{
				addMissingBlock(oldModid, newModid, i+"_picket_fence", i+"_picket_fence");
				addMissingBlock(oldModid, newModid, i+"_stockade_fence", i+"_stockade_fence");
				addMissingBlock(oldModid, newModid, i+"_horse_fence", i+"_horse_fence");
				addMissingBlock(oldModid, newModid, i+"_wired_fence", i+"_wired_fence");
				addMissingBlock(oldModid, newModid, i+"_highley_gate", i+"_highley_gate");
				addMissingBlock(oldModid, newModid, i+"_pyramid_gate", i+"_pyramid_gate");
			}
			if(this.Hedges)
			{
				for(String i : this.leaves)
				{
					addMissingBlock(oldModid, newModid, i+"_hedge", i+"_hedge");
				}
			}
		}
		
		public void missingnoStoneBlock()
		{		
			for(String i : this.mat_rockable)
			{
				addMissingBlock(oldModid, newModid, "modern_"+i+"_wall", "modern_"+i+"_wall");
				addMissingBlock(oldModid, newModid, "railing_"+i+"_wall", "railing_"+i+"_wall");
				addMissingBlock(oldModid, newModid, i+"_railing_gate", i+"_railing_gate");
				addMissingBlock(oldModid, newModid, i+"_pillar_wall", i+"_pillar_wall");
				addMissingBlock(oldModid, newModid, i+"_grass_topped_wall", i+"_grass_topped_wall");
			}
		}
		
	}
	
	public static class Bridges
	{
		protected String oldModid;
		protected String newModid;
		protected List<String> mats;
		protected List<String> mat_rockable;

		public Bridges(String oldModid, String newModid, List<String> mats)
		{
			this.oldModid = oldModid;
			this.newModid = newModid;
			this.mats = mats;
		}
		
		public Bridges(String oldModid, String newModid, List<String> mats_wooden, List<String> mat_rockable)
		{
			this(oldModid, newModid, mats_wooden);
			this.mat_rockable  = mat_rockable;
		}
		
		public void missingnoWoodBlock()
		{		
			for(String i : this.mats)
			{
				addMissingBlock(oldModid, newModid, i+"_log_bridge_middle", i+"_log_bridge_middle");
				addMissingBlock(oldModid, newModid, "rope_"+i+"_bridge", "rope_"+i+"_bridge");
				addMissingBlock(oldModid, newModid, i+"_bridge_pier", i+"_bridge_pier");
				addMissingBlock(oldModid, newModid, i+"_log_bridge_stair", i+"_log_bridge_stair");
				addMissingBlock(oldModid, newModid, i+"_rope_bridge_stair", i+"_rope_bridge_stair");
				addMissingBlock(oldModid, newModid, i+"_rail_bridge", i+"_rail_bridge");
			}
		}
				
		public void missingnoStoneBlock(boolean balustrade)
		{
			for(String i : this.mat_rockable)
			{
				addMissingBlock(oldModid, newModid, i+"_bridge", i+"_bridge");
				addMissingBlock(oldModid, newModid, i+"_bridge_pier", i+"_bridge_pier");
				addMissingBlock(oldModid, newModid, i+"_bridge_stair", i+"_bridge_stair");
				if(balustrade)
				{
					addMissingBlock(oldModid, newModid, "balustrade_"+i+"_bridge", "balustrade_"+i+"_bridge");
				}
			}
		}
		
		/*use missingnoStoneBlock(, boolean balustrade)*/
		@Deprecated
		public void missingnoStoneBlock()
		{
			missingnoStoneBlock(false);
		}
	}
	
	protected static void addMissingBlock(String oldModid, String newModid, String oldName, String newName)
	{
        File file = FabricLoader.getInstance().getConfigDir().resolve("ufu.txt").toFile();

        /*Basic ufu.txt File : https://github.com/SilverAndro/UpdateFixerUpper/blob/master/src/main/java/io/github/silverandro/ufu/UpdateFixerUpper.java*/
        if (!file.exists())
        {
        	try
			{
                BufferedWriter buffer = new BufferedWriter(new FileWriter(file, true));
				
				buffer.write("// Make sure to make backups!\n");
				buffer.write("// Format is <old identifier> -> <new identifier>\n");
				buffer.write("// Example: removed_mod:bad_block_or_item -> added_mod:good_block_or_item\n");
				buffer.write("// You can press F3 to see block IDs on the right, and F3 + H to see item IDs\n");
				
				buffer.close();
				file.createNewFile();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
        }
        
        
        try
		{
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file, true));
			
			buffer.write(oldModid+":"+oldName+" -> "+newModid+":"+newName+"\n");
			
			buffer.close();
			file.createNewFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}