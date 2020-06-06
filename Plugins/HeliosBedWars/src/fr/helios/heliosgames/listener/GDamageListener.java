package fr.helios.heliosgames.listener;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import fr.helios.heliosgames.GMain;
import fr.helios.heliosgames.GState;

public class GDamageListener implements Listener
{
    private GMain main;
    
    public GDamageListener(GMain main)
    {
        this.main = main;
    }
    
    @EventHandler
    public void onDamage(EntityDamageEvent event)
    {
        Entity victim = event.getEntity();
        
        if(!main.isState(GState.PLAYING))
        {
            event.setCancelled(true);
            return; 
        }
        
        if(victim instanceof Player)
        {
            Player player = (Player)victim;
            if(player.getHealth() <= event.getDamage())
            {
                event.setDamage(0);
                main.eliminatePlayer(player);
            }
        }
    }
    
    @EventHandler
    public void onPvP(EntityDamageByEntityEvent event)
    {
        Entity victim = event.getEntity();
        
        if(!main.isState(GState.PLAYING))
        {
            event.setCancelled(true);
            return; 
        }
        
        if(victim instanceof Player)
        {
            Player player = (Player)victim;
            Player damager = (Player)event.getDamager();
            Player killer = player;
            
            if(player.getHealth() <= event.getDamage())
            {
                
                if(damager instanceof Player) killer = (Player)damager;
                
                if(damager instanceof Arrow)
                {
                    Arrow arrow = (Arrow)damager;
                    if(arrow.getShooter() instanceof Player)
                    {
                        killer = (Player)arrow.getShooter();
                    }
                }
                
                killer.sendMessage("Tu viens de tuer §c" + player.getName());
                event.setDamage(0);
                main.eliminatePlayer(player);
            }
        }
    }
}
