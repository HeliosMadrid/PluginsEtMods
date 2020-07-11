package fr.helios.stplugin;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.Lists;

import fr.helios.stplugin.commands.ComCommand;
import fr.helios.stplugin.commands.EnergyCommand;
import fr.helios.stplugin.commands.PNGCommand;
import fr.helios.stplugin.commands.TestCommand;
import fr.helios.stplugin.commands.tpverslaplaneteCommand;
import fr.helios.stplugin.commands.tab.TabPNG;
import fr.helios.stplugin.event.EventManager;

public class StarTreckPlugin extends JavaPlugin
{
    private static StarTreckPlugin instance;
    
    @Override
    public void onEnable()
    {
        instance = this;
        
        commands();
        
        EventManager.registerEvents();
    }
    
    @Override
    public void onDisable()
    {
        
    }
    
    public static StarTreckPlugin getINSTANCE()
    {
        return instance;
    }
    
    private void commands() {
        getCommand("png").setExecutor(new PNGCommand());
        getCommand("png").setAliases(Lists.newArrayList("pnj"));
        getCommand("png").setTabCompleter(new TabPNG());
        
        getCommand("energy").setExecutor(new EnergyCommand());
        
        getCommand("tpverslaplanete").setExecutor(new tpverslaplaneteCommand());
        
        getCommand("testIos").setExecutor(new TestCommand());
        
        getCommand("com").setExecutor(new ComCommand());
    }
}
