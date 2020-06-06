package fr.helios.plugios.util;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EffectBlood implements Listener
{
    @EventHandler
    public void onEntityBlood(EntityDamageByEntityEvent event)
    {
        Entity victim = event.getEntity();
        Location victimLoc = victim.getLocation();
        
        if(victim.getType() != EntityType.ITEM_FRAME)
        {
            victim.getWorld().playEffect(victimLoc, Effect.STEP_SOUND, Material.OBSIDIAN);
            victim.getWorld().playEffect(victimLoc, Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
            victim.getWorld().playEffect(victimLoc, Effect.STEP_SOUND, Material.REDSTONE_WIRE);
            victim.getWorld().playEffect(victimLoc, Effect.STEP_SOUND, Material.REDSTONE_TORCH_ON);
            victim.getWorld().playEffect(victimLoc, Effect.STEP_SOUND, Material.NETHER_WART_BLOCK);
        }
    }
    
}
