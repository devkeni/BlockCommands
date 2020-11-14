package com.devkeni.blockcommands;

import org.bukkit.plugin.java.JavaPlugin;
import com.devkeni.blockcommands.events.EventBlockCommand;

public class BlockCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        loadConfig();
        loadEvents();
    }

    private void loadConfig() {
        saveDefaultConfig();
        reloadConfig();
    }

    private void loadEvents() {
        getServer().getPluginManager().registerEvents(new EventBlockCommand(), this);
    }

}
