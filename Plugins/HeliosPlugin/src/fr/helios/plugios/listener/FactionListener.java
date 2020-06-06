package fr.helios.plugios.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.factions.event.EventFactionsChunksChange;

public class FactionListener implements Listener
{
    @EventHandler
    public void claimOrUnclaim(EventFactionsChunksChange event)
    {
        if(event.getNewFaction() == event.getMPlayer().getFaction())
        {
            MPlayer mp = event.getMPlayer();
            Player player = mp.getPlayer();
            
            player.sendMessage("test");
        }
        
        else 
        {
            
        }
    }
}
