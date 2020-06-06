package fr.helios.astralplugin;


//import org.bukkit.Bukkit;
//import org.bukkit.World;
//import org.bukkit.WorldBorder;
import org.bukkit.plugin.java.JavaPlugin;

import fr.helios.astralplugin.commands.CommandChestRandom;
import fr.helios.astralplugin.commands.CommandSpawn;
import fr.helios.astralplugin.commands.CommandTest;
//import fr.helios.astralplugin.task.TimerTask;

public class AstralPlugin extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        super.onEnable();
        saveDefaultConfig();
        getCommand("test").setExecutor(new CommandTest(this));
        getCommand("alert").setExecutor(new CommandTest(this));
        getCommand("spawn").setExecutor(new CommandSpawn());
        getCommand("event").setExecutor(new CommandChestRandom(this));
        getServer().getPluginManager().registerEvents(new AstralPluginListener(this), this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        
        /*TimerTask task = new TimerTask();
        task.runTaskTimer(this, 0, 20);
        
        World world = Bukkit.getWorld("world");
        WorldBorder wb = world.getWorldBorder();
        wb.setCenter(0, 0);
        wb.setSize(1000);
        wb.setDamageAmount(1);
        
        Bukkit.getScheduler().runTaskTimer(this, new Runnable()
        {
            
            @Override
            public void run()
            {
                if(wb.getSize() >= 25)
                {
                wb.setSize(wb.getSize() - 1.0);
                }
            }
            
        }, 0, 20);*/
    }
    
    @Override
    public void onDisable()
    {
        super.onDisable();
    }
}
