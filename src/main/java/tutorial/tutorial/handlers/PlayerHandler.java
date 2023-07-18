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

import java.util.List;

public class PlayerHandler implements Listener {
    private final List<String> itemList;

    public PlayerHandler(Tutorial plugin, List<String> itemList) {
        this.itemList = itemList;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.hasPlayedBefore()) {
            // Player has played before, do nothing
            return;
        }

        Inventory inventory = player.getInventory();
        for (String itemName : itemList) {
            Material material = Material.getMaterial(itemName);

            if (material != null) {
                ItemStack item = new ItemStack(material, 1);
                inventory.addItem(item);
            }
        }
    }
}
