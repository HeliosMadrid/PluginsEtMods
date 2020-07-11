package fr.helios.stplugin.event.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import fr.helios.stplugin.entity.projectile.AmmoBase;

public class StarTreckListener implements Listener
{
    @EventHandler
    public void saveWorld(InventoryOpenEvent event)
    {
        for(World world : Bukkit.getWorlds())
        {
            world.save();
        }
    }

    @EventHandler
    public void showLCD(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        World world = player.getWorld();
        Action action = event.getAction();
        Material block = event.getClickedBlock().getType();

        if(block == Material.SOUL_LANTERN && action == Action.RIGHT_CLICK_BLOCK)
        {
            if(!player.isSneaking())
            {
                // colone de droite
                world.getBlockAt(488, 88, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(488, 89, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(488, 90, -416).setType(Material.NETHER_PORTAL);

                world.getBlockAt(487, 89, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(487, 90, -416).setType(Material.NETHER_PORTAL);

                world.getBlockAt(486, 89, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(486, 90, -416).setType(Material.NETHER_PORTAL);

                world.getBlockAt(485, 89, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(485, 90, -416).setType(Material.NETHER_PORTAL);

                world.getBlockAt(484, 89, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(484, 90, -416).setType(Material.NETHER_PORTAL);

                world.getBlockAt(483, 89, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(483, 90, -416).setType(Material.NETHER_PORTAL);

                world.getBlockAt(482, 89, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(482, 90, -416).setType(Material.NETHER_PORTAL);

                world.getBlockAt(481, 89, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(481, 90, -416).setType(Material.NETHER_PORTAL);

                world.getBlockAt(480, 89, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(480, 90, -416).setType(Material.NETHER_PORTAL);
                // ligne du bas
                world.getBlockAt(487, 88, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(486, 88, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(485, 88, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(484, 88, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(483, 88, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(482, 88, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(481, 88, -416).setType(Material.NETHER_PORTAL);
                world.getBlockAt(480, 88, -416).setType(Material.NETHER_PORTAL);
            }
            else
            {
                // colone de droite
                world.getBlockAt(488, 88, -416).setType(Material.AIR);
                world.getBlockAt(488, 89, -416).setType(Material.AIR);
                world.getBlockAt(488, 90, -416).setType(Material.AIR);

                world.getBlockAt(487, 89, -416).setType(Material.AIR);
                world.getBlockAt(487, 90, -416).setType(Material.AIR);

                world.getBlockAt(486, 89, -416).setType(Material.AIR);
                world.getBlockAt(486, 90, -416).setType(Material.AIR);

                world.getBlockAt(485, 89, -416).setType(Material.AIR);
                world.getBlockAt(485, 90, -416).setType(Material.AIR);

                world.getBlockAt(484, 89, -416).setType(Material.AIR);
                world.getBlockAt(484, 90, -416).setType(Material.AIR);

                world.getBlockAt(483, 89, -416).setType(Material.AIR);
                world.getBlockAt(483, 90, -416).setType(Material.AIR);

                world.getBlockAt(482, 89, -416).setType(Material.AIR);
                world.getBlockAt(482, 90, -416).setType(Material.AIR);

                world.getBlockAt(481, 89, -416).setType(Material.AIR);
                world.getBlockAt(481, 90, -416).setType(Material.AIR);

                world.getBlockAt(480, 89, -416).setType(Material.AIR);
                world.getBlockAt(480, 90, -416).setType(Material.AIR);
                // ligne du bas
                world.getBlockAt(487, 88, -416).setType(Material.AIR);
                world.getBlockAt(486, 88, -416).setType(Material.AIR);
                world.getBlockAt(485, 88, -416).setType(Material.AIR);
                world.getBlockAt(484, 88, -416).setType(Material.AIR);
                world.getBlockAt(483, 88, -416).setType(Material.AIR);
                world.getBlockAt(482, 88, -416).setType(Material.AIR);
                world.getBlockAt(481, 88, -416).setType(Material.AIR);
                world.getBlockAt(480, 88, -416).setType(Material.AIR);
            }
        } 
    }
    
    @EventHandler
    public void gunLancher(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        
        if(player.getItemInHand() == null) return;
        if(!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        
        if(player.getItemInHand().getType() == Material.DIAMOND_HOE) {
            player.launchProjectile(Arrow.class).setGravity(false);
        } else if(player.getItemInHand().getType() == Material.GOLDEN_HOE) {
            player.launchProjectile(new AmmoBase(null, 100, 1, 20, false, true, (byte)666).getClass());
        } else if(player.getItemInHand().getType() == Material.IRON_HOE) {
        	player.launchProjectile(LargeFireball.class);
        } else if(player.getItemInHand().getType() == Material.FISHING_ROD) {
        	event.setCancelled(true);
        	player.launchProjectile(DragonFireball.class).setGlowing(true);
        }else if(player.getItemInHand().getType() == Material.WOODEN_HOE) {
        	player.launchProjectile(Snowball.class).setGravity(false);
        } else if(player.getItemInHand().getType() == Material.STONE_HOE) {
        	player.launchProjectile(Trident.class).setGravity(false);
        }
    }
    
    @EventHandler
    public void explosedFireBall(ProjectileHitEvent event) {
    	if(event.getEntityType() == EntityType.DRAGON_FIREBALL) {
    		event.getEntity().getWorld().createExplosion(event.getHitBlock().getLocation(), 25);
    	} else if(event.getEntityType() == EntityType.SNOWBALL) {
    		event.getHitEntity().setVelocity(new Vector(0, 0, 0));
    		event.getHitEntity().setCustomName("Paralysé");
    		event.getHitEntity().setCustomNameVisible(true);
    		Entity entity = event.getHitEntity();
    	}
    }
    
    @EventHandler
    public void clearInv(PlayerDeathEvent event) {
    	for(ItemStack item : event.getEntity().getInventory()) {
    		if(item.getType() == Material.TRIDENT) {
    			event.getEntity().getInventory().remove(item);
    		}
    	}
    }
}
