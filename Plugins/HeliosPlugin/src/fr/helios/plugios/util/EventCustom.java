package fr.helios.plugios.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class EventCustom implements Listener
{
    @EventHandler
    public void onTNTBreak(BlockBreakEvent event)
    {
        if(event.getBlock().getType() == Material.TNT)
        {
            Bukkit.getPluginManager().callEvent(new TntBreakEvent(event.getBlock(), event.getPlayer()));
        }
    }
    
    @EventHandler
    public void breakTntEvent(TntBreakEvent event)
    {
        event.protocle(Material.ANVIL, "Les builder ne doivent pas jouer avec la TnT");
    }
}