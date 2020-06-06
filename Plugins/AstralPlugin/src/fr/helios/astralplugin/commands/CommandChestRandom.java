package fr.helios.astralplugin.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.helios.astralplugin.AstralPlugin;

public class CommandChestRandom implements CommandExecutor
{
    private AstralPlugin main;

    public CommandChestRandom(AstralPlugin astralPlugin)
    {
        this.setMain(astralPlugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("event"))
        {
            Random r = new Random();
            double x = 0 + r.nextInt(500);
            double y = 0 + r.nextInt(100);
            double z = 0 + r.nextInt(100);
            
            Location spawnChest = new Location(Bukkit.getWorld("world"), x, y, z);
            Location spawnChestB = new Location(Bukkit.getWorld("world"), x, y - 1, z);
            Location spawnChestT = new Location(Bukkit.getWorld("world"), x, y + 1, z);
            
            /*while(!(spawnChestB.getBlock().getType() == Material.AIR) && !(spawnChestT.getBlock().getType() == Material.STONE))
            {
                if(!(spawnChestB.getBlock().getType() == Material.AIR) && (spawnChestT.getBlock().getType() == Material.STONE))
                {
                    spawnChest.getBlock().setType(Material.CHEST);
                }
            }*/
            if(!(spawnChestB.getBlock().getType() == Material.AIR) && !(spawnChestT.getBlock().getType() == Material.STONE))
            {
                spawnChest.getBlock().setType(Material.CHEST);
                Bukkit.broadcastMessage("§aGood Coffre");
            }
            else 
            {
                Bukkit.broadcastMessage("§4Bad Coffre");
            }
            
            Chest chest = (Chest)spawnChest.getBlock().getState();
            Inventory chestMenu = chest.getInventory();
            
            if(Math.random() * 100 < 99)
            {
                chestMenu.setItem(r.nextInt(chestMenu.getSize()), new ItemStack(Material.DIAMOND, r.nextInt(8)));
            }
            if(Math.random() * 100 < 48)
            {
                chestMenu.setItem(r.nextInt(chestMenu.getSize()), new ItemStack(Material.IRON_SWORD, r.nextInt(2)));
            }
            if(Math.random() * 100 < 100)
            {
                chestMenu.setItem(r.nextInt(chestMenu.getSize()), new ItemStack(Material.BEDROCK, r.nextInt(3)));
            }
            if(Math.random() * 100 < 13)
            {
                chestMenu.setItem(r.nextInt(chestMenu.getSize()), new ItemStack(Material.BLUE_SHULKER_BOX, r.nextInt(1)));
            }
            if(Math.random() * 100 < 23)
            {
                chestMenu.setItem(r.nextInt(chestMenu.getSize()), new ItemStack(Material.ELYTRA, r.nextInt(4)));
            }
            if(Math.random() * 100 < 74)
            {
                chestMenu.setItem(r.nextInt(chestMenu.getSize()), new ItemStack(Material.NETHER_STAR, 1)); 
            }
            if(Math.random() * 100 < 1)
            {
                chestMenu.setItem(r.nextInt(chestMenu.getSize()),new ItemStack(Material.AIR, r.nextInt(64)));
            }
                       
            Bukkit.broadcastMessage("Un coffre spawn en §ax:§a" + x + "§r, en §by:§b" + y + " §ret en §cz:§c" + z + " §rAller le chercher et soyez le premier");
            
            return true;
        }
        
        return false;
    }

    public AstralPlugin getMain()
    {
        return main;
    }

    public void setMain(AstralPlugin main)
    {
        this.main = main;
    }

}
