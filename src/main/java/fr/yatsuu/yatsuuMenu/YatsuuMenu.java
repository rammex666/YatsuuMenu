package fr.yatsuu.yatsuuMenu;

import fr.yatsuu.yatsuuMenu.commands.ReloadCommand;
import fr.yatsuu.yatsuuMenu.events.PlayerJoinListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class YatsuuMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("YatsuuMenu is enabled!");

        // Register commands

        registerCommands();

        // Register events

        registerEvents();

        // Config

        saveDefaultConfig();

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().info("YatsuuMenu is disabled.");

        getServer().getMessenger().unregisterOutgoingPluginChannel(this, "BungeeCord");

    }

    @SuppressWarnings("ConstantConditions")
    private void registerCommands() {

        this.getCommand("ymreload").setExecutor(new ReloadCommand(this));

    }

    private void registerEvents() {

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new PlayerJoinListener(this), this);

    }

}
