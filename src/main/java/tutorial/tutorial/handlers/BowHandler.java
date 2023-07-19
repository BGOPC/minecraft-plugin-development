package tutorial.tutorial.handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import tutorial.tutorial.Tutorial;

import org.bukkit.Material;

public class BowHandler implements Listener {
    public BowHandler(Tutorial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        if (heldItem.getType() == Material.BOW && heldItem.hasItemMeta() && heldItem.getItemMeta().hasLore()){
            if (heldItem.getItemMeta().getLore().contains(ChatColor.GREEN + "Teleport Bow")) {
                event.setCancelled(true);
                player.teleport(event.getClickedBlock().getLocation());
            }
        }
    }
}
