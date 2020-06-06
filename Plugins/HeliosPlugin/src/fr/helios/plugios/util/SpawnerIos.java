package fr.helios.plugios.util;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SpawnerIos implements Listener
{   
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onSpawnPlace(BlockPlaceEvent event)
    {
        Block block = event.getBlock();
        
        if(block.getType() == Material.MOB_SPAWNER)
        {
            String spawnName = event.getPlayer().getItemInHand().getItemMeta().getDisplayName();
            CreatureSpawner spawner = (CreatureSpawner)event.getBlock().getState();
            spawner.setCreatureTypeByName(spawnName);
        }
    }
    
}
