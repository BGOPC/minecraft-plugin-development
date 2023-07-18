package tutorial.tutorial.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tutorial.tutorial.Tutorial;

public class PlayerHandler implements Listener {
    public PlayerHandler(Tutorial plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ItemStack item = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
        Inventory inventory = player.getInventory();
        inventory.addItem(item);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("U mama");
        inventory.setItem(7, item);
    }
}
