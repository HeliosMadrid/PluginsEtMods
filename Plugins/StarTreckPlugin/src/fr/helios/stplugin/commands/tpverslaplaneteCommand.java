package fr.helios.stplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpverslaplaneteCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player player = Bukkit.getPlayer(args[0]);
        
        player.teleport(new Location(Bukkit.getWorld("world_nether"), 0, 70, 0));
        
        return true;
    }

}
