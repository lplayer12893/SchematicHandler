/**
 * 
 */
package schematichandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
