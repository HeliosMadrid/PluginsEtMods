package fr.helios.stplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Vindicator;
import org.bukkit.util.Vector;

public class PNGCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player player = (Player)sender;
        Villager vil = (Villager)player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
        
        if(args.length > 0) {
        	if(args[0].equalsIgnoreCase("Boss")) {
        		Vindicator vin = (Vindicator) player.getWorld().spawnEntity(player.getLocation(), EntityType.VINDICATOR);
        		vin.setAbsorptionAmount(100);
        		vin.setMaxHealth(500);
        		vin.setHealth(500);
        		vin.setCustomName("Klingon Blanc");
        		vin.setCustomNameVisible(true);
        		vin.setFireTicks(20);
        		vin.setGlowing(true);
        		vin.setTarget(Bukkit.getPlayer("Jaera_Hells"));
        		vin.damage(20);
        		vin.setVelocity(new Vector(10, 10, 10));
        		
        		return true;
        	}
            vil.setCustomName(args[0]);
            vil.setCustomNameVisible(true);
            if(args.length > 1) {
                switch(args[1]) {
                    case "Rouge":
                        vil.setCustomName("§4".concat(args[0]));
                        break;
                    case "Vert":
                        vil.setCustomName("§2".concat(args[0]));
                        break;
                    case "Bleu":
                        vil.setCustomName("§9".concat(args[0]));
                        break;
                    case "Jaune":
                        vil.setCustomName("§e".concat(args[0]));
                        break;
                    case "Rouge Claire":
                        vil.setCustomName("§c".concat(args[0]));
                        break;
                    case "Or":
                        vil.setCustomName("§6".concat(args[0]));
                        break;
                    case "Vert Claire":
                        vil.setCustomName("§a".concat(args[0]));
                        break;
                    case "Aqua":
                        vil.setCustomName("§b".concat(args[0]));
                        break;
                    case "Aqua Foncé":
                        vil.setCustomName("§3".concat(args[0]));
                        break;
                    case "Bleu Foncé":
                        vil.setCustomName("§1".concat(args[0]));
                        break;
                    case "Rose":
                        vil.setCustomName("§d".concat(args[0]));
                        break;
                    case "Violet":
                        vil.setCustomName("§5".concat(args[0]));
                        break;
                    case "Blanc":
                        vil.setCustomName("§f".concat(args[0]));
                        break;
                    case "Gris":
                        vil.setCustomName("§7".concat(args[0]));
                        break;
                    case "Gris Foncé":
                        vil.setCustomName("§8".concat(args[0]));
                        break;
                    case "Noir":
                        vil.setCustomName("§0".concat(args[0]));
                        break;
                    case "Gras":
                        vil.setCustomName("§l".concat(args[0]));
                        break;
                    case "Italic":
                        vil.setCustomName("§o".concat(args[0]));
                        break;
                    case "Rayé":
                        vil.setCustomName("§m".concat(args[0]));
                        break;
                    case "Souligné":
                        vil.setCustomName("§n".concat(args[0]));
                        break;
                    case "Changeant":
                        vil.setCustomName("§k".concat(args[0]));
                        break;
                    
                    default: break;
                }
                if(args.length > 2) {
                    if(Boolean.valueOf(args[2])) {
                        vil.setInvulnerable(true);
                    } else {
                        vil.setInvulnerable(false);
                    }
                }
            }
        }
        
        return true;
    }

}
