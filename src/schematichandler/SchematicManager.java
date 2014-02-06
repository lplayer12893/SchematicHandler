package schematichandler;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalPlayer;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.sk89q.worldedit.data.DataException;

/**
 * @author Lucas Stuyvesant
 * This class contains methods to load and place schematics
 */
public class SchematicManager {
	
	/**
	 * The WorldEdit hook
	 */
	public static WorldEditPlugin weplugin = null;
	
	public void onEnable(){
		weplugin = getWorldEdit();
	}
	
	/**
	 * method for WorldEdit to get the WorldEdit Plugin
	 * @return the WorldEdit Plugin
	 */
	public static WorldEditPlugin getWorldEdit() {
	    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
	 
	    // WorldGuard may not be loaded
	    if (plugin == null || !(plugin instanceof WorldEditPlugin)) {
	        return null; // Maybe you want throw an exception instead
	    }
	 
	    return (WorldEditPlugin) plugin;
	}
	/*
	 * TODO:
	 * Outline of Creative Gallery Functionality (bank functions the same)
	 * Go to creative, buy schematic.
	 * bought schematic is in personal CuboidClipboard
	 * paste schematic
	 * 	- check area for worldguard regions (no overlap at all)
	 * 	- create EditSession, and create backup?
	 *  - paste
	 *  - buy the land and apply protections
	 * undo or continue
	 * rinse repeat
	 * ...
	 * once multiple schematics are owned, can merely select (not buy) to load a schematic
	 * 		into CuboidClipboard
	 * ALTERNATIVELY paste command can have an argument schematic name and will load to 
	 * 		CuboidClipboard prior to paste.
	 * 
	 * possible commands:
	 * 	- paste
	 * 	- load [schematic_name]
	 * 	- paste [schematic_name]
	 * 	- printClipboard 
	 * 		o Prints the name of the schematic in the clipboard, or null if there is none
	 * 	- listSchematics
	 * 		o Lists all schematics owned by CommandSender
	 * 
	 * need to know who owns each schematic
	 * 	- map of schematics to list of players
	 * 	- individual schematic file prefaced by player username (ie lplayer12893__bank)
	 * 	- write it down in config files?
	 */
	
	/**
	 * @param filename name of schematic file
	 * @return a CuboidClipboard representation of the schematic
	 */
	@SuppressWarnings("deprecation")
	public CuboidClipboard loadSchematic(String filename){
		
		File file = new File(filename);
		CuboidClipboard clipboard = null;
		
		try {
			//for the life of me I cannot figure out how to not use this depreciated function
			clipboard = CuboidClipboard.loadSchematic(file);
		} catch (DataException e) {
		} catch (IOException e) {
		}
		
		return clipboard;
	}
	
	/**
	 * @param c CuboidClipboard to be saved to file
	 * @param filename
	 */
	@SuppressWarnings("deprecation")
	public void saveSchematic(CuboidClipboard c, String filename){
		
		File file = new File(filename);
		
		try {
			c.saveSchematic(file);
		} catch (DataException e) {
		} catch (IOException e) {
		}
	}
	
	/**
	 * @param player pasting the schematic
	 * @param cc clipboard from which the schematic is being pasted
	 */
	public void pasteSchematic(LocalPlayer player, CuboidClipboard cc){
		
		Selection selection = weplugin.getSelection((Player) player);
		
		EditSession editor = new EditSession(player.getWorld(), selection.getArea());
		
		try {	//not sure this works, theoretically puts the clipboard content in the editor region
			cc.paste(editor, selection.getRegionSelector().getPrimaryPosition(), true);
		} catch (MaxChangedBlocksException e) {
		} catch (IncompleteRegionException e) {
		}
	}
	
}
