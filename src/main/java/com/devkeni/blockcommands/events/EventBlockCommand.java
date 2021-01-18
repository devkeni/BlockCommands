package com.devkeni.blockcommands.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import com.devkeni.blockcommands.utilities.Utils;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class EventBlockCommand implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void blockCommand(PlayerCommandPreprocessEvent event) {

        Player player = event.getPlayer();
        List<String> bypassedPlayers = Utils.getBypassedPlayers();

        if (bypassedPlayers.contains(player.getName)) return;

        String command = event.getMessage();
        List<String> blockedCommands = Utils.getBlockedCommands();
        
        for (String blockedCommand : blockedCommands) {
            if (command.toLowerCase().startsWith(blockedCommand.toLowerCase())) {
                event.setCancelled(true);
                player.sendMessage(Utils.getPermissionMessage());
            }
        }
    }

}
