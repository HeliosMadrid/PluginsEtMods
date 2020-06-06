package fr.helios.astralplugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
//import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AstralPluginListener implements Listener
{
    private AstralPlugin main;
    
    public AstralPluginListener(AstralPlugin astralPlugin)
    {
        this.main = astralPlugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event)
    {
       Inventory inv = event.getInventory();
       Player player = (Player)event.getWhoClicked();
       ItemStack current = event.getCurrentItem();
       
       if(current == null) return;
       
       if(inv.getName().equalsIgnoreCase("§8Mon Menu"))
       {
           event.setCancelled(true);
           Random random = new Random();
           int enjeux = random.nextInt(2);
           
           switch(current.getType())
           {               
               case APPLE:

                   if(player.getGameMode() == GameMode.ADVENTURE || player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SURVIVAL)
                   {
                       player.closeInventory();
                       player.setGameMode(GameMode.SPECTATOR);
                   }
                   
                   else if(player.getGameMode() == GameMode.SPECTATOR)
                   {
                       player.closeInventory();
                       player.setGameMode(GameMode.SURVIVAL);
                   }
                   
                   break;
                   
               case ANVIL:
                   
                   player.closeInventory();
                   player.getInventory().addItem(new ItemStack(Material.TNT, 64));
                   player.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL, 1));
                   
                   break; 
                   
                case EYE_OF_ENDER:
                                        
                    switch(enjeux)
                    {
                        case 0:                            
                            player.getWorld().dropItem(player.getLocation(), new ItemStack(Material.ENDER_PORTAL));
                            break;
                            
                        case 1: 
                            player.getWorld().spawnEntity(player.getLocation(), EntityType.ENDERMAN);
                            break;
                            
                        default:
                            player.getWorld().spawnEntity(player.getLocation(), EntityType.BLAZE);
                        break;
                            
                    }
                    break;
            default:
                break;
           }

        }
    }
    
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        
        ItemStack customSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemStack bed = new ItemStack(Material.BED, 1);
        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        ItemStack shield = new ItemStack(Material.SHIELD, 1);
        ItemStack customWool = new ItemStack(Material.WOOL, 32, (byte)14);
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 64, (byte)3);
        
        ItemMeta customM = customSword.getItemMeta();
        ItemMeta customC = compass.getItemMeta();
        ItemMeta customB = bed.getItemMeta();
        SkullMeta metaSkull = (SkullMeta)skull.getItemMeta();
        ItemMeta customShield = shield.getItemMeta();
        
        player.getInventory().clear();     
        
        customM.setDisplayName("§1Ma super épée");
        customM.setLore(Arrays.asList("appartient à :" + player.getName(), "enchantements :" + customSword.getEnchantments(), "sert à : tuer", "Exp:" + player.getExp()));
        customM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
        //customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        
        customC.setDisplayName("§8Speed");
        customC.setUnbreakable(true);
        customC.addEnchant(Enchantment.FIRE_ASPECT, Integer.MAX_VALUE, true);
        customC.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        
        customB.setDisplayName("§7Gui");
        customB.setUnbreakable(true);
        
        customSword.setItemMeta(customM);
        compass.setItemMeta(customC);
        bed.setItemMeta(customB);
        
        metaSkull.setOwner("luck");
        metaSkull.setDisplayName("§6Lucky Block");
        skull.setItemMeta(metaSkull);
        
        customShield.setDisplayName("§dBouclier de Lache");
        customShield.setUnbreakable(true);
        customShield.addEnchant(Enchantment.THORNS, 999, true);
        shield.setItemMeta(customShield);
        
        player.getInventory().setItemInMainHand(customSword);
        player.getInventory().setItem(8, bed);
        player.getInventory().setItemInOffHand(shield);
        player.getInventory().addItem(compass);
        player.getInventory().setHelmet(customWool);
        player.getInventory().setBoots(skull);
        player.updateInventory();
    }
    
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event)
    {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        BlockState bs = block.getState();
        
        if(bs instanceof Skull)
        {
            Skull skull = (Skull) bs;
            if(skull.getOwner().equalsIgnoreCase("luck"))
            {
                event.setCancelled(true);
                block.setType(Material.AIR);
                
                Random random = new Random();
                int alea = random.nextInt(5);
                
                switch(alea)
                {
                    case 0:
                        
                        player.sendMessage("vous n'êtes pas très chanceux");
                        
                        break;
                        
                    case 1:
                        
                        block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.DIAMOND, 3));
                        
                        break;
                        
                    case 2:
                        
                        block.getWorld().setStorm(true);
                        
                        break;
                        
                    case 3:
                        
                        player.setDisplayName("Je suis débile car j'ai tenter de jouer avec la tête du Dieux §6Luck");
                        
                        break;
                        
                    case 4:
                        
                        block.getWorld().generateTree(new Location(Bukkit.getWorld("world"), player.getLocation().getX() + 1, player.getLocation().getY() + 1, player.getLocation().getZ() + 1, player.getLocation().getYaw(), player.getLocation().getPitch()), TreeType.CHORUS_PLANT);
                        
                        break;
                        
                    default: 
                        
                        block.getWorld().createExplosion(block.getLocation(), 10);
                        
                        break;
                }
            }
        }
    }
    
    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if(event.getClickedBlock() != null && action == Action.RIGHT_CLICK_BLOCK)
        {
            BlockState bs = event.getClickedBlock().getState();

            if(bs instanceof Sign)
            {
                Sign sign = (Sign)bs;
                
                //clear
                if(sign.getLine(0).equalsIgnoreCase("[clear]") && sign.getLine(1).equalsIgnoreCase("all"))
                {
                    player.getInventory().clear();
                    player.sendMessage("vous venez d'être clear");
                }

                //teleport bungee
                if(sign.getLine(0).equalsIgnoreCase("[Teleport]") && sign.getLine(1).equalsIgnoreCase("bungee"))
                {
                    if(sign.getLine(2) != null)
                    {
                        String serverName = sign.getLine(2);
                        
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        
                        try 
                        {
                            out.writeUTF("Connect");
                            out.writeUTF(serverName);
                        }
                        catch(IOException e)
                        {
                            e.printStackTrace();
                        }
                        
                        player.sendPluginMessage(main, "BungeeCord", b.toByteArray());
                    }
                }
            }
        }
        
        if(it == null) return ;
        
        if(it.getType() == Material.DIAMOND_HOE)
        {
            if(action == Action.RIGHT_CLICK_AIR)
            player.sendMessage("Plugin de Helios_38");
        }
        
        if(it.getType() == Material.BED && it.hasItemMeta() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§7Gui"))
        {
            Inventory inv = Bukkit.createInventory(null, 54, "§8Mon Menu");     
            
            inv.setItem(11, getItem(Material.APPLE, "§4passer en gamemode 3"));
            inv.setItem(12, getItem(Material.ANVIL, "§5Give Tnt"));
            inv.setItem(13, getItem(Material.EYE_OF_ENDER, "§0Give soit 1 ender_portal soit summon enderMan"));
            
            player.openInventory(inv);
        }
        
        if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§8Speed"))
        {
            if(player.hasPotionEffect(PotionEffectType.SPEED) == false && player.hasPotionEffect(PotionEffectType.JUMP) == false) 
            {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 5));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 5));
            }
            
            else if(player.hasPotionEffect(PotionEffectType.SPEED) == true && player.hasPotionEffect(PotionEffectType.JUMP) == true)
            {
                player.removePotionEffect(PotionEffectType.SPEED);
                player.removePotionEffect(PotionEffectType.JUMP);
            }
            
            if(player.isSneaking() && player.hasPotionEffect(PotionEffectType.LEVITATION) == false)
            {
                player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, Integer.MAX_VALUE, 5));
            } 
            
            else if(player.isSneaking() && player.hasPotionEffect(PotionEffectType.LEVITATION) == true)
            {
                player.removePotionEffect(PotionEffectType.LEVITATION);
            }
        }
    }
    
    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event)
    {
        Block block = event.getBlockPlaced();
        Player player = event.getPlayer();
        
        if(((ItemStack)block).hasItemMeta() && ((ItemStack)block).getItemMeta().getDisplayName().equalsIgnoreCase("§7Gui"))
        {
            event.setCancelled(true);
            player.sendMessage("N'essayer pas de posé ce block il vous est très utile");
            return;
        }
    }
    
    public ItemStack getItem(Material material, String customName)
    {
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if(customName != null) itM.setDisplayName(customName);
        it.setItemMeta(itM);
        return it;
    }
}
