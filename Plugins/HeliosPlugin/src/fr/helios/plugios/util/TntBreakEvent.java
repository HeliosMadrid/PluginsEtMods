package fr.helios.plugios.util;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TntBreakEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();
    private Block block;
    private Player player;
    
    public TntBreakEvent(Block block, Player player)
    {
        this.block = block;
        this.player = player;
    }
    
    public Block getTnt()
    {
        return this.block;
    }
    
    public Player getPlayer()
    {
        return this.player;
    }
    
    public void protocle(Material material, String msg)
    {
        this.block.setType(material);
        this.player.sendMessage(msg);
    }
    
    public HandlerList getHandlers()
    {
        return handlers;
    }
    
    public static HandlerList getHandlerList()
    {
        return handlers;
    }
}
