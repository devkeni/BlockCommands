package com.devkeni.blockcommands.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class ConfigManager {

    private final Plugin instance;

    public ConfigManager(Plugin instance) {
        this.instance = instance;
    }

    public FileConfiguration getConfig(){
        return instance.getConfig();
    }

    public List<String> getBlockedCommands() {
        return getConfig().getStringList("blocked-commands");
    }

    public List<String> getBypassedPlayers() {
        return getConfig().getStringList("bypassed-players");
    }

    public String getPermissionMessage() {
        return getConfig().getString("permission-message").replace("&", "§");
    }

}
