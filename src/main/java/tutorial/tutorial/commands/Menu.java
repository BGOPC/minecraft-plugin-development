package tutorial.tutorial.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tutorial.tutorial.Tutorial;

import java.util.ArrayList;
import java.util.List;

public class Menu implements CommandExecutor, Listener {
    private String InvName = "Server Selector";

    public Menu(Tutorial plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(InvName)) return;

        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();
        // DO SOMETHING IF SLOT WAS ...

        event.setCancelled(true);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player p = (Player) sender;
        Inventory inventory = Bukkit.createInventory(p, 9 * 3, InvName);
        inventory.setItem(11, getItem(new ItemStack(Material.DIAMOND_SWORD), "&9PVP", "&aClick To Join", "&Battle It In PvP Arena"));
        inventory.setItem(13, getItem(new ItemStack(Material.BEACON), "&9PVP", "&aClick To Join", "&Battle It In PvP Arena"));
        inventory.setItem(15, getItem(new ItemStack(Material.GRASS_BLOCK), "&9PVP", "&aClick To Join", "&Battle It In PvP Arena"));
        p.openInventory(inventory);
        return true;
    }

    private ItemStack getItem(ItemStack item, String name, String... lore) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<String>();
        for (String l : lore) {
            lores.add(ChatColor.translateAlternateColorCodes('&', l));
        }
        meta.setLore(lores);

        item.setItemMeta(meta);
        return item;
    }
}
