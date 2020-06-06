package fr.helios.heliosgames.task;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import fr.helios.heliosgames.GMain;
import fr.helios.heliosgames.GState;

public class GAutoStart extends BukkitRunnable
{
    private int timer = 10;
    private GMain main;

    public GAutoStart(GMain main)
    {
        this.main = main;
    }

    @Override
    public void run()
    {
        for(Player pls : main.getPlayers())
        {
            pls.setLevel(timer);
        }
        
        if(timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1)
        {
            Bukkit.broadcastMessage("Lancement du jeu dans : §a" + timer + "s");
        }
        
        if(timer == 0)
        {
            Bukkit.broadcastMessage("Lancement du jeu!!! On se réveille PvP dans 30s");
            main.setState(GState.PLAYING);
            
            for(int i = 0; i < main.getPlayers().size(); i++)
            {
                Player player = main.getPlayers().get(i);
                Location spawn = main.getSpawns().get(i);
                player.teleport(spawn);
                player.getInventory().clear();
                player.setGameMode(GameMode.SURVIVAL);
                player.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD, 1));
                player.updateInventory();
            }
            GGameCycle cycle = new GGameCycle(main);
            cycle.runTaskTimer(main, 0, 20);
            
            cancel();
        }
        
        timer--;
    }
    
}
