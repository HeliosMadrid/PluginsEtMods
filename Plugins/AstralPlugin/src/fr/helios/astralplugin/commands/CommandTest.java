package fr.helios.astralplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.helios.astralplugin.AstralPlugin;

public class CommandTest implements CommandExecutor
{
    
    private AstralPlugin main;
    public boolean timerB = false; 

    public CommandTest(AstralPlugin astralPlugin)
    {
        this.main = astralPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
    {
        timerB = true; 
        
        if(sender instanceof Player)
        {
            Player player = (Player)sender;
            
            if(cmd.getName().equalsIgnoreCase("test"))
            {
                player.sendMessage(main.getConfig().getString("message.test").replace("&", "§"));
                return true;
            }
            
            if(cmd.getName().equalsIgnoreCase("alert"))
            {
                if(args.length == 0)
                {
                    player.sendMessage("la commande est /alert <message>");
                }
                
                if(args.length >= 1)
                {
                    StringBuilder bc = new StringBuilder();
                    for(String part : args)
                    {
                        bc.append(part + " ");
                    }
                    
                    Bukkit.broadcastMessage("[" + player.getName() + "]" + bc.toString());
                }
                
                return true;
            }
        }
        
        return false;
    }

}
