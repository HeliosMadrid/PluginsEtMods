package fr.helios.stplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
    	Player player = (Player) sender;
    	
        return true;
    }

}
