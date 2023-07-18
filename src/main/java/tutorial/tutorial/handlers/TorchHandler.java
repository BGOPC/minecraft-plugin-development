package tutorial.tutorial.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import tutorial.tutorial.Tutorial;

public class TorchHandler implements Listener {
    public TorchHandler(Tutorial plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    /*
    Lowest
    Low
    Normal
    High
    Highest
    -------
    Monitor: It'll run after everything and can't do any changes
     */
//    @EventHandler(priority = EventPriority.LOW) // This Piece will run sooner
//    public void onTorchPlace_Low(BlockPlaceEvent event) {
//        if (event.getBlock().getType() != Material.TORCH) return;
//        event.setCancelled(true);
//    }
//    @EventHandler
//    public void onTorchPlace_Normal(BlockPlaceEvent event) {
//        Block block = event.getBlock();
//        if (block.getType() != Material.TORCH) return;
//
//        Bukkit.getLogger().info("Torch Was Placed");
//    }

    @EventHandler
    public void onTorchPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() != Material.TORCH || !event.getPlayer().hasPermission("tutorial.torch.diamond")) return;


    }
}
