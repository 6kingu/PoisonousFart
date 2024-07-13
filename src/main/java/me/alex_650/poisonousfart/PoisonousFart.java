package me.alex_650.poisonousfart;

import me.alex_650.poisonousfart.Events.onShift;
import org.bukkit.plugin.java.JavaPlugin;

public final class PoisonousFart extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("farting...");

        getServer().getPluginManager().registerEvents(new onShift(), this);
        registerCommands(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands(PoisonousFart plugin) {
        getCommand("fart").setExecutor(new me.alex_650.poisonousfart.Commands.onCommand());
    }
}