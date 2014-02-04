package schematichandler;

/**
 * @author Lucas Stuyvesant
 * This class contains methods to load and place schematics
 */
public class SchematicManager {

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
	
}
