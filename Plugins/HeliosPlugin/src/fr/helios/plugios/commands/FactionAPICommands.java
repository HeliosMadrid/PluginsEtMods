package fr.helios.plugios.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.ps.PS;

public class FactionAPICommands implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player && cmd.getName().equalsIgnoreCase("faction"))
        {
            Player player = (Player) sender;
            MPlayer mp = MPlayer.get(player);
            Faction f = mp.getFaction();
            Faction factionAt = BoardColl.get().getFactionAt(PS.valueOf(player.getLocation()));
            
            player.sendMessage("Votre faction se nomme: " + f.getName());
            player.sendMessage("Vous avez actuellement " + mp.getPower() + "de Power");
            player.sendMessage("Vous êtes actuellement sur le territoire de la faction: " + factionAt.getName());
        }
        
        return false;
    }
}