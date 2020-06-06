package fr.helios.plugios.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullIos implements Listener
{
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        Player player = event.getEntity();
        List<String> lore = new ArrayList<> ();
        lore.add("ce crâne appartient à §1" + player.getName());
        lore.add( "voici le message que §1" + player.getName() +  "voulais te dire");
        
        if(player instanceof Player)
        {
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
            
            SkullMeta skullM = (SkullMeta)skull.getItemMeta();
            
            skullM.setOwner(player.getName());
            skullM.setUnbreakable(true);
            skullM.setLore(lore);
            skullM.setDisplayName("crâne de §1" + player.getName());
            skullM.setLocalizedName("crâne de §1" + player.getName());
            
            skull.setItemMeta(skullM);

            player.getWorld().dropItem(player.getLocation(), skull);
            
        }
    }
}
