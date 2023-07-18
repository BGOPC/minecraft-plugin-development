package tutorial.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Hello World");

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Goodbye World");
    }
}
