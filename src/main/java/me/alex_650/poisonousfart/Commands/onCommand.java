package me.alex_650.poisonousfart.Commands;

import me.alex_650.poisonousfart.Events.onShift;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class onCommand implements CommandExecutor {

    private static Map<UUID, Boolean> active = new HashMap<>();

    public static Map<UUID, Boolean> getActive() {
        return active;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {

        if (!(cs instanceof Player)) return true;

        Player player = (Player) cs;

        if (!player.hasPermission("PoisonousFart.fart")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cOpsie! Looks like you have no gas in your belly!"));
        }

        if (active.containsKey(player.getUniqueId())) {
            active.remove(player.getUniqueId());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNo more gas :)"));
        } else {
            active.put(player.getUniqueId(), true);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aToo much tacos?"));
        }

        return true;
    }
}
