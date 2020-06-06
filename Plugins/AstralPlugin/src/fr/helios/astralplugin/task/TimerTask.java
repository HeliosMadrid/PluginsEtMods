package fr.helios.astralplugin.task;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import fr.helios.astralplugin.AstralPlugin;
import fr.helios.astralplugin.commands.CommandTest;

public class TimerTask extends BukkitRunnable
{
    
    private int timer = 10;
    private AstralPlugin astralplugin;
    public CommandTest cmdTest = new CommandTest(astralplugin);

    @Override
    public void run()
    {
        if(cmdTest.timerB == true)
        {
        Bukkit.broadcastMessage("Lancement du jeu dans" + timer + "s");
        
        if(timer == 0)
        {
            Bukkit.broadcastMessage("Lancement du jeu!!!");
            cancel();
        }
        
        timer--;
        }
    }

}
