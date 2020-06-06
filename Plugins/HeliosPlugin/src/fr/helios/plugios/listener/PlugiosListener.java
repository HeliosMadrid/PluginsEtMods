package fr.helios.plugios.listener;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.helios.plugios.PlugIios;

public class PlugiosListener implements Listener
{
    
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event)
    {
        Player player = event.getPlayer();
        String msg = event.getMessage();
        String[] args = msg.split(" ");
        
        if(args[0].equalsIgnoreCase("/t"))
        {
            if(args.length == 1)
            {
                player.sendMessage("§4Tape §2/e §e<jour>§d/§8<nuit>");
            }
            
            else if(args.length == 2)
            {
                if(args[1].equalsIgnoreCase("jour"))
                {
                    player.getWorld().setTime(0);
                }
                
                else if(args[1].equalsIgnoreCase("nuit"))
                {
                    player.getWorld().setTime(15000);
                }
            }
            
            event.setCancelled(true);
        }
        
        else if(args[0].equalsIgnoreCase("/mob"))
        {
            Zombie z = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
            z.setCustomName("Robert");
            z.setCustomNameVisible(true);
            z.getEquipment().setHelmet(new ItemStack(Material.TNT, 1));
            z.getEquipment().setHelmetDropChance(100000.0F);
            z.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
            z.getEquipment().setChestplateDropChance(10000000.0F);
            z.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999, 50, true));
            
            event.setCancelled(true);
        }
        
        else if(args[0].equalsIgnoreCase("/giveIos"))
        {
            player.sendMessage("§d[GIVE], §2Diamant || Apple || Golden_Apple || Head || Beacon || Diamond_Block || Emeraud || Emeraud_Block || EXP || Sable || Epee || Houe || Pelle || Hache || Pioche || Arc || Coffre || Fourneau || Casque || Plastron || Jambieres || Bottes || Restone || Exp_Bootles || Lapis_Lazuli || Fer || Or || Bois || Livre || Porte_Armure || Poudre_De_Blaze || Patates || Patates_Cuites || BedRock || Enclume || Command_Block || Baton_De_Blaze || Charbon || Block_De_Charbon || Blé || Shulker_Box || Fruit_Du_Chorus || Fleur_Du_Chorus || Baton || Carrote || Pancarte || Obsidienne || Levier || Torche_A_Redstone || Torche || Coffre_Pieger || Porte || Seau_D'eau || Seau_De_Lave || Seau_De_Lait || TNT || Piston || Piston_Collant || Wagonnet || Barque");
            event.setCancelled(true);
        }
        
        else if(args[0].equalsIgnoreCase("/task"))
        {
            if(args.length == 1)
            {
                player.sendMessage("§4La commande est /task §2<durée(0.1.2.3.4.5.6.7.8.9.10.ect..)>");
            }
            else
            {
            int i = Integer.valueOf(args[1]);
            PlugIios.getInstance().startCountdown(i);
            }
            
            event.setCancelled(true);
        }
        
        else if(args[0].equalsIgnoreCase("/tprandom"))
        {
            Random rand = new Random();
            
            double x = player.getLocation().getBlockX() + rand.nextInt((int)500.0D);
            double y = player.getLocation().getBlockY();
            double z = player.getLocation().getBlockZ() + rand.nextInt((int)500.0D);
            Location randLoc= new Location(player.getWorld(), x, y, z);
            player.teleport(randLoc);
            
            event.setCancelled(true);
        }
        
        else if(args[0].equalsIgnoreCase("/tpme"))
        {
            if(args.length >= 3)
            {
                double x = Double.valueOf(args[1]);
                double y = Double.valueOf(args[2]);
                double z = Double.valueOf(args[3]);
                
                Location myloc = new Location(player.getWorld(), x, y, z);
                player.teleport(myloc);
            }
            else
            {
                player.sendMessage("la syntaxe est §e/§1tpme §4<§ax, y, z§4>");
            }
            
            event.setCancelled(true);
        }
        
        else if(args[0].equalsIgnoreCase("/kit"))
        {
            ItemStack swordD = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta customS = swordD.getItemMeta();
            customS.setDisplayName("épée en saphire");
            customS.setUnbreakable(true);
            customS.addEnchant(Enchantment.DAMAGE_ALL, 9999, true);
            customS.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            customS.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            customS.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            customS.addItemFlags(ItemFlag.HIDE_DESTROYS);
            swordD.setItemMeta(customS);
            
            player.getInventory().addItem(swordD);
            
            
            event.setCancelled(true);
        }
        
        else if(args[0].equalsIgnoreCase("/wb") && args[1] != null)
        {
            loadBorders(player, Double.valueOf(args[1]));
            
            event.setCancelled(true);
        }
        
        else if(args[0].equalsIgnoreCase("/start"))
        {
            player.sendMessage("§5Bravo tu a essayé un truc sans succès");
            player.setCustomName("Je suis §aBête");
            player.setCustomNameVisible(true);
            player.setDisplayName("Je suis §aBête");
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10 * 20, 999), true);
            player.setSneaking(true);
            event.setCancelled(true);
        }
        
        else if(args[0].equalsIgnoreCase("/broadcast"))
        {
            if(player.hasPermission("broadcast.util"))
            {
            player.getServer().broadcastMessage(ChatColor.AQUA + "[Annonce]" + ChatColor.GREEN + " Ceci est une annonce !");
            }
            else
            {
                player.sendMessage("§4Vous n'avez pas le droit de faire ceci");
            }
            event.setCancelled(true);
        }
    }
    
    public void loadBorders(Player player, double size)
    {
        World w = Bukkit.getWorld("world");
        WorldBorder wb = w.getWorldBorder();
        wb.setCenter(player.getLocation());
        wb.setSize(size);
    }
    
}