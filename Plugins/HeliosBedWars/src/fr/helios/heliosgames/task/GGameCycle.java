package fr.helios.heliosgames.task;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.helios.heliosgames.GMain;

public class GGameCycle extends BukkitRunnable
{
    private GMain main;
    private int timer = 60;
    
    public GGameCycle(GMain main)
    {
        this.main = main;
    }
    
    @Override
    public void run()
    {
        if(timer == 30 || timer == 15 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1)
        {
            Bukkit.broadcastMessage("Combat final dans :" + timer + "s");
        }
        
        if(timer == 0)
        {
            for(Player pls : main.getPlayers())
            {
                pls.teleport(new Location(Bukkit.getWorld("world"), 229.700, 40, 207.700, 134.4F, 1.3F));
            }
            
            cancel();
        }
            
        timer--;
    }

}
