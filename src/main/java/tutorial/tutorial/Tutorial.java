package tutorial.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tutorial.tutorial.commands.Fly;
import tutorial.tutorial.commands.Menu;
import tutorial.tutorial.handlers.*;

import java.util.Objects;

public final class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Hello World");

        saveDefaultConfig();
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Fly());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Menu(this));
        new TorchHandler(this);
        new PlayerHandler(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Goodbye World");
    }
}
