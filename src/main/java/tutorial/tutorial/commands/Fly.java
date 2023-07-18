package tutorial.tutorial.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (player.getAllowFlight()){
            player.setAllowFlight(false);
            player.sendMessage("Fly Disabled");
        } else {
            player.setAllowFlight(true);
            player.sendMessage("Fly Enabled");
        }
        return true;
    }
}
