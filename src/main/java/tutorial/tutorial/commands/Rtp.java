package tutorial.tutorial.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rtp implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        int maxAttempts = 10;
        int maxDistance = 10000;

        for (int i = 0; i < maxAttempts; i++) {
            double x = player.getLocation().getX() + (Math.random() * 2 - 1) * maxDistance;
            double z = player.getLocation().getZ() + (Math.random() * 2 - 1) * maxDistance;

            Location randomLocation = new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt((int) x, (int) z) + 1, z);

            if (randomLocation.getBlock().getType().isAir()) {
                player.teleport(randomLocation);
            }
        }
    }
}
