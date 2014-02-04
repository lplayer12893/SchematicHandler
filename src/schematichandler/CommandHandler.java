/**
 * 
 */
package schematichandler;

import org.bukkit.Bukkit;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.m0pt0pmatt.bettereconomy.BetterEconomy;
import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.StateFlag.State;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

/**
 * @author Lucas Stuyvesant
 */
public class CommandHandler {
	
	/**
	 * command handler. handles all schematic commands
	 */
	public static boolean commands(CommandSender sender, Command cmd, String label, String[] args){
		
		/**
		 * admin wants to evaluate the economy (currencies)
		 */
		if(cmd.getName().equalsIgnoreCase("paste")){
			
			if (!(sender instanceof Player)){
				sender.sendMessage("Must be a Player to execute");
				return false;
			}
			
			//TODO: functionality and more commands
						
			return true;
		}
		
		return false;
	}
}
