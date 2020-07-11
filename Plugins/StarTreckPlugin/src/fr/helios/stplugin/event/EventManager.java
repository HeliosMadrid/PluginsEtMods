package fr.helios.stplugin.event;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.helios.stplugin.StarTreckPlugin;
import fr.helios.stplugin.commands.ComCommand;
import fr.helios.stplugin.event.events.StarTreckListener;

public class EventManager
{
    private static final PluginManager pm = Bukkit.getPluginManager();
    
    public static void registerEvents() {
       pm.registerEvents(new StarTreckListener(), StarTreckPlugin.getINSTANCE());
       pm.registerEvents(new ComCommand(), StarTreckPlugin.getINSTANCE());
    }
}
