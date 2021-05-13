package com.devkeni.blockcommands.listeners;

import com.devkeni.blockcommands.managers.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandListener implements Listener {

    private final ConfigManager config;

    public PlayerCommandListener(ConfigManager configManager) {
        config = configManager;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage();

        if (config.getBypassedPlayers().contains(player.getName())) return;

        for (String blockedCommand : config.getBlockedCommands()) {
            if (command.toLowerCase().startsWith(blockedCommand.toLowerCase())) {
                event.setCancelled(true);
                player.sendMessage(config.getPermissionMessage());
            }
        }
    }

}