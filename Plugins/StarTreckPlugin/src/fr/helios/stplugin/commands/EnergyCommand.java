package fr.helios.stplugin.commands;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnergyCommand implements CommandExecutor
{
    public static boolean energy = false;
    private int chrono = 30;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player player = (Player)sender;
        if(player.getWorld() == Bukkit.getWorld("worlda")) {
            player.teleport(new Location(Bukkit.getWorld("world"), 493, 88, 414));
            return true;
        }
        
        energy = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { 
            @Override
            public void run()
            {
                chrono--;
                if(chrono <= 0) {
                    timer.cancel();
                    energy = false;
                }
            }
        }, 1000, 1000);
        return true;
    }

}
