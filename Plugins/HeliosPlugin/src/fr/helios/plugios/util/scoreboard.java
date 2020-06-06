package fr.helios.plugios.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class scoreboard implements Listener
{
    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        ItemStack sign = new ItemStack(Material.SIGN, 64);
        Player player = event.getPlayer();        
        ScoreboardManager sb = Bukkit.getScoreboardManager();
        Scoreboard board = sb.getNewScoreboard();
        
        player.getInventory().setItemInOffHand(sign);
        Objective obj = board.registerNewObjective("§2" + player.getName() + "§1Ios", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§eScores");
        
        Score play = obj.getScore("Joueurs: §e" + Bukkit.getOnlinePlayers().size());
        play.setScore(5);
        Score death = obj.getScore("Morts: §4" + player.getStatistic(Statistic.DEATHS));
        death.setScore(4);
        
        player.setScoreboard(board);
    }

}
