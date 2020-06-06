package fr.helios.duel.arenas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class ArenaManager
{
    private List<Arena> arenas = new ArrayList<>();
    
    public void addArena(Arena arena)
    {
        this.arenas.add(arena);
    }
    
    public void joinArena(Player firstPlayer, Player secondPlayer)
    {
        Arena nextArena = getNextArena();
        
        if(nextArena != null)
        {
            nextArena.getPlayers().add(firstPlayer);
            nextArena.getPlayers().add(secondPlayer);
            firstPlayer.teleport(nextArena.getLoc1());
            firstPlayer.teleport(nextArena.getLoc2());
            nextArena.setStart();
        }
        else
        {
            firstPlayer.sendMessage("§cIl n'y a aucune arène disponible pour faire un duel");
            secondPlayer.sendMessage("§cIl n'y a aucune arène disponible pour faire un duel");
        }
    }
    
    public  Arena getArenaByPlayer(Player player)
    {
        for(Arena arena: arenas)
        {
            if(arena.getPlayers().contains(player))
            {
                return arena;
            } 
        }
        return null;
    }

    private Arena getNextArena()
    {
        for(Arena arena : arenas)
        {
            if(!arena.isStarted())
            {
                return arena;
            }
        }
        return null;
    }
    
    public List<Arena> getArenas()
    {
        return arenas;
    }
}
