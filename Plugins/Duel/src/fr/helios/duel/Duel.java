package fr.helios.duel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.helios.duel.arenaListener.ArenaListener;
import fr.helios.duel.arenas.Arena;
import fr.helios.duel.arenas.ArenaManager;

public class Duel extends JavaPlugin
{
    private Map<Player, Player> players = new HashMap<>();
    private ArenaManager arenaManager = new ArenaManager();
    private File arenaFile;
    private YamlConfiguration arenaConfig;
    
    @Override
    public void onEnable()
    {
        getCommand("duel").setExecutor(this);
        getServer().getPluginManager().registerEvents(new ArenaListener(this), this);
        
        //creat file arenas.yml
        loadArenaConfig();
        
        ConfigurationSection arenSection = arenaConfig.getConfigurationSection("arenas");
        
        for(String string : arenSection.getKeys(false))
        {
            String loc1 = arenSection.getString(string + ".loc1");
            String loc2 = arenSection.getString(string + ".loc2");
            Arena arena = new Arena(parseStringToLock(loc1), parseStringToLock(loc2));
            arenaManager.addArena(arena);
        }
    }
    
    private void loadArenaConfig()
    {
        if(!getDataFolder().exists())
        {
            getDataFolder().mkdir();
        }
        
        arenaFile = new File(getDataFolder() + File.separator + "arenas.yml");
        
        if(!arenaFile.exists())
        {
            try
            {
                arenaFile.createNewFile();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        
        arenaConfig = YamlConfiguration.loadConfiguration(arenaFile);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(label.equalsIgnoreCase("duel") && sender instanceof Player)
        {
            Player player = (Player)sender;
            
            if(args.length == 0)
            {
                player.sendMessage("§e/§6duel §r<§1player§r>");
                player.sendMessage("§e/§6duel §r<§aaccept§r/§4deny§r>");
                return true;
            }
            else if(args.length >= 1)
            {
                String targetName = args[0];
                
                if(args[0].equalsIgnoreCase("accept"))
                {
                    if(players.containsKey(player))
                    {
                        player.sendMessage("Ok, le duel ce lance!");
                        
                        Player firstPlayerTarget = players.get(player);
                        firstPlayerTarget.sendMessage("Ok, le duel ce lance!");
                        
                        //teleport
                        player.teleport(new Location(Bukkit.getWorld("arena"), -2, 1, 0, -154.7F, 2.9F));
                        firstPlayerTarget.teleport(new Location(Bukkit.getWorld("arena"), -6, 4, -15, -70.4F, 9.6F));
                        
                        players.remove(player);
                    }
                    
                }
                else if(args[0].equalsIgnoreCase("deny"))
                {
                    if(players.containsKey(player))
                    {
                        player.sendMessage("Ok, duel §4refusé§r §l§o(Pfff... trop nul moi qui voulait un bon combat bien sanglant...)");
                        Player firstPlayerTarget = players.get(player);
                        firstPlayerTarget.sendMessage("Le jouer §e" + player.getName() + "§r a §4refusé§r le duel");
                        players.remove(player);
                    }
                }
                
                else if(args[0].equalsIgnoreCase("createarena"))
                {
                    if(args.length < 3)
                    {
                        player.sendMessage("tapez §e/§4duel §dcreatearena §1<loc1> §b<loc2>");
                        return true;
                    }
                    
                    Location loc1 = parseStringToLock(args[1]);
                    Location loc2 = parseStringToLock(args[2]);
                    Arena arena = new Arena(loc1, loc2);
                    String arenaName = "arena-" + new Random().nextInt(9999);
                    
                    
                    arenaConfig.set("arenas." + arenaName + ".loc1", args[1]);
                    arenaConfig.set("arenas." + arenaName + ".loc2", args[2]);
                    try
                    {
                        arenaConfig.save(arenaFile);
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    
                    arenaManager.addArena(arena);
                    player.sendMessage("Vous avez créé une §4arène: §1" + arenaName + " §r!");
                }
                
                else if(Bukkit.getPlayer(targetName) != null)
                {
                    Player target = Bukkit.getPlayer(targetName);
                    
                    if(players.containsKey(target))
                    {
                        player.sendMessage("Attention ce joueur a déjà un demande en cours");
                        return true;
                    }
                    
                    players.put(target, player);
                    player.sendMessage("Vous venez d'envoyer une demande de §4duel §rà§b" + targetName + "§rattendez qu'il fasse son §dchoix");
                    target.sendMessage("§b" + player.getName() + "§rviens de vous demander en §4duel pour §aaccepter §rfaite §6/§aaccept §rou pour §crefuser §rfaite §6/§cdeny");
                }
                else
                {
                    player.sendMessage("Le jouer §c" + targetName + "§r n'existe pas ou n'est pas en ligne");
                }
                
                return true;
            }
        }
        
        return false;
    }

    public ArenaManager getArenaManager()
    {
        return arenaManager;
    }
    
    public Location parseStringToLock(String string)
    {
        String[] parsedloc = string.split(",");
        double x = Double.valueOf(parsedloc[0]);
        double y = Double.valueOf(parsedloc[1]);
        double z = Double.valueOf(parsedloc[2]);
        float yaw = Float.valueOf(parsedloc[3]);
        float pitch = Float.valueOf(parsedloc[4]);
        
        return new Location(Bukkit.getWorld("world"), x, y, z, yaw, pitch);
    }
    
    public String unparseLocToString(Location loc)
    {
        return loc.getX() + "," + loc.getY() + "," +loc.getZ() + "," + loc.getYaw() + "," + loc.getPitch();
    }
}
