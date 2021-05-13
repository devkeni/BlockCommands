package com.devkeni.blockcommands;

import com.devkeni.blockcommands.listeners.PlayerCommandListener;
import com.devkeni.blockcommands.managers.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockCommands extends JavaPlugin {

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        loadConfig();
        configManager = new ConfigManager(this);
        registerListeners();
    }

    private void loadConfig() {
        saveDefaultConfig();
        reloadConfig();
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerCommandListener(configManager), this);
    }

}