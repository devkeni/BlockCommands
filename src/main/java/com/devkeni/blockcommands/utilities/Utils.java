package com.devkeni.blockcommands.utilities;

import org.bukkit.plugin.java.JavaPlugin;
import com.devkeni.blockcommands.BlockCommands;

import java.util.List;

public class Utils {

    public static List<String> getBlockedCommands() {
        return getInstance().getConfig().getStringList("config.blocked-commands");
    }

    public static List<String> getBypassedPlayers() {
        return getInstance().getConfig().getStringList("config.bypassed-players");
    }

    public static String getPermissionMessage() {
        return getInstance().getConfig().getString("config.permission-message");
    }

    public static BlockCommands getInstance() {
        return JavaPlugin.getPlugin(BlockCommands.class);
    }

}