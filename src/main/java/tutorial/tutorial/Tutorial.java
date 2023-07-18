package tutorial.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tutorial.tutorial.commands.Fly;
import tutorial.tutorial.handlers.*;

public final class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Hello World");
        getCommand("fly").setExecutor(new Fly());
        new TorchHandler(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Goodbye World");
    }
}
