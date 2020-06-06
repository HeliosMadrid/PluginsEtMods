package fr.helios.duel.arenas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Arena
{
    private Location loc1;
    private Location loc2;
    private List<Player> players;
    private boolean isStarted;
    
    public Arena(Location loc1, Location loc2)
    {
        this.setLoc1(loc1);
        this.setLoc2(loc2);
        restart();
    }

    public Location getLoc1()
    {
        return loc1;
    }

    public void setLoc1(Location loc1)
    {
        this.loc1 = loc1;
    }

    public Location getLoc2()
    {
        return loc2;
    }

    public void setLoc2(Location loc2)
    {
        this.loc2 = loc2;
    }

    public List<Player> getPlayers()
    {
        return players;
    }

    public void setPlayers(List<Player> players)
    {
        this.players = players;
    }

    public boolean isStarted()
    {
        return isStarted;
    }

    public void setStarted(boolean isStarted)
    {
        this.isStarted = isStarted;
    }
    
    public void setStart()
    {
        this.isStarted = true;
    }

    public void eliminate(Player victim)
    {
        players.remove(victim);
        checkWin();
    }

    private void checkWin()
    {
        if(players.size() == 1)
        {
            Player winner = players.get(0);
            Bukkit.broadcastMessage("§1" + winner.getName() + " §rgagne le §4duel");
            restart();
        }
    }

    private void restart()
    {
        this.setPlayers(new ArrayList<>());
        this.setStarted(false);
    }
}
