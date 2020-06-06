package fr.helios.plugios;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class Artifice implements Listener
{   
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
    {
        Player player = event.getPlayer();
        Firework f = (Firework) player.getWorld().spawnEntity(event.getBlock().getLocation(), EntityType.FIREWORK);
        f.detonate();
        FireworkMeta fm = f.getFireworkMeta();
        FireworkEffect effect = FireworkEffect.builder()
                .flicker(true)
                .withColor(Color.AQUA)
                .withFade(Color.PURPLE)
                .with(Type.STAR)
                .trail(true)
                .build();
        fm.addEffect(effect);
        f.setFireworkMeta(fm);
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onItemDropped(PlayerDropItemEvent event)
    {
        Player player = event.getPlayer();
        Location loc = new Location(player.getWorld(), event.getItemDrop().getLocation().getX(), event.getItemDrop().getLocation().getY(), event.getItemDrop().getLocation().getZ());
        if(player.getItemInHand().getType() == Material.CHORUS_PLANT)
        {
        Firework f = (Firework) player.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        f.detonate();
        FireworkMeta fm = f.getFireworkMeta();
        FireworkEffect effect = FireworkEffect.builder()
                .flicker(true)
                .withColor(Color.AQUA)
                .withFade(Color.PURPLE)
                .with(Type.STAR)
                .trail(true)
                .build();
        fm.addEffect(effect);
        f.setFireworkMeta(fm);
        }
    }
}
