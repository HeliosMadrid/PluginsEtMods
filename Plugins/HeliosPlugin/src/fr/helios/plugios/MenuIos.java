package fr.helios.plugios;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MenuIos implements Listener
{   
    @EventHandler
    public void onClickBoussole(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        
        if(event.getItem().getType() == Material.COMPASS && event.getAction() == Action.RIGHT_CLICK_AIR)
        {
            Inventory inv = Bukkit.createInventory(null, 9, "Menu de mini-jeux");
            ItemStack coffre = new ItemStack(Material.CHEST, 1);
            
            inv.setItem(0, coffre);
            
            player.openInventory(inv);
        }
    }

}
