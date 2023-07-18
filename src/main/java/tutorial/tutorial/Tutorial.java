package tutorial.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tutorial.tutorial.commands.Fly;
import tutorial.tutorial.commands.Menu;
import tutorial.tutorial.handlers.*;

import java.util.List;
import java.util.Objects;

public final class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Hello World");

        saveDefaultConfig();

        List<String> starterKit = (List<String>) getConfig().getList("kits");
        // Pass this to Player Join Event, so the player gets this
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Fly());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Menu(this));
        new TorchHandler(this);
        new PlayerHandler(this, starterKit);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Goodbye World");
    }
}
