package me.alex_650.poisonousfart.Events;

import me.alex_650.poisonousfart.Commands.onCommand;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.bukkit.util.Vector;

import java.util.Map;
import java.util.UUID;

public class onShift implements Listener {

    private final Map<UUID, Boolean> active = onCommand.getActive();

    @EventHandler
    public void onShift (PlayerToggleSneakEvent event) {

        Player player = event.getPlayer();

        if (!active.containsKey(player.getUniqueId())) return;

        if (player.isFlying()) return;

        if (!event.isSneaking()) return;

        ItemStack poisonPotion = new ItemStack(Material.LINGERING_POTION);

        PotionMeta meta = (PotionMeta) poisonPotion.getItemMeta();

        meta.setBasePotionData(new PotionData(PotionType.POISON));poisonPotion.setItemMeta(meta);

        Location playerLoc = player.getLocation();Vector direction = playerLoc.getDirection();direction.multiply(-1);Location dropLoc =  playerLoc.add(direction);

        ThrownPotion thrownPotion = player.getWorld().spawn(dropLoc, ThrownPotion.class);
        thrownPotion.setItem(poisonPotion);

    }
}
