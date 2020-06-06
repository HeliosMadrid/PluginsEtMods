package fr.helios.heliosgames.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.helios.heliosgames.GMain;
import fr.helios.heliosgames.GState;
import fr.helios.heliosgames.task.GAutoStart;

public class GPlayerListener implements Listener
{
    private GMain main;

    public GPlayerListener(GMain main)
    {
        this.main = main;
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        Location spawn = new Location(Bukkit.getWorld("world"), 198.981, 84, 252.046, -179.7F, 88.0F);
        player.teleport(spawn);
        player.getInventory().clear();
        player.setFoodLevel(20);
        player.setHealth(20);
        player.setSaturation(40);
        player.setGameMode(GameMode.ADVENTURE);
        
        if(main.isState(GState.WAITING))
        {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("Le jeu a deja démarrer!");
            event.setJoinMessage(null);
            return;
        }
        
        if(!main.getPlayers().contains(player)) main.getPlayers().add(player);
        event.setJoinMessage("§7[§aHeliosGames§7]§r" + player.getName() + "§a a rejoint la partie ! <" + main.getPlayers().size() + "/" + Bukkit.getMaxPlayers() + ">");
        
        if(main.isState(GState.WAITING) && main.getPlayers().size() == 2)
        {
            GAutoStart start = new GAutoStart(main);
            start.runTaskTimer(main, 0, 20);
            main.setState(GState.STARTING);
        }
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        if(main.getPlayers().contains(player))
        {
            main.getPlayers().remove(player);
        }
        
        event.setQuitMessage("§a" + player.getName() + "§eleft");
        main.chekWin();
    }
    
    @EventHandler
    public void onPlace(BlockPlaceEvent event)
    {
        if(!main.isState(GState.PLAYING))
        {
            event.setCancelled(true);
            return; 
        }
    }
    
    @EventHandler
    public void onBreak(BlockBreakEvent event)
    {
        if(!main.isState(GState.PLAYING))
        {
            event.setCancelled(true);
            return; 
        }
    }

}
