package fr.helios.heliosgames;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.helios.heliosgames.listener.GDamageListener;
import fr.helios.heliosgames.listener.GPlayerListener;

public class GMain extends JavaPlugin
{
    private List<Player> players = new ArrayList<Player>();
    private List<Location> spawns = new ArrayList<Location>();
    private GState state;
    
    @Override
    public void onEnable()
    {
        super.onEnable();
        setState(GState.WAITING);
        World world = Bukkit.getWorld("world");
        spawns.add(new Location(world, 229.700, 40, 198.300, 52.2F, 2.7F));
        spawns.add(new Location(world, 225.300, 40, 201, -130.4F, 2.2F));
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new GPlayerListener(this), this);
        pm.registerEvents(new GDamageListener(this), this);
    }
    
    public void setState(GState state)
    {
        this.state = state;
    }
    
    public boolean isState(GState state)
    {
        return this.state == state;
    }

    public List<Player> getPlayers()
    {
        return players;
    }
    
    public List<Location> getSpawns()
    {
        return spawns;
    }

    public void eliminatePlayer(Player player)
    {
        if(players.contains(player)) players.remove(player);
        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage("Vous avais §4PERDU gros §aNUL!!!!");
        chekWin();
    }

    public void chekWin()
    {
        if(players.size() == 1)
        {
            Player winner = players.get(0);
            Bukkit.broadcastMessage(winner.getName() + "gagne le jeu!");
            Bukkit.spigot().restart();
        }
    }

}
