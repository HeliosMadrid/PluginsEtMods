package fr.helios.plugios.util;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class PanneauIos implements Listener
{
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        BlockState block = event.getClickedBlock().getState();
        Player player = event.getPlayer();
        Sign sign = (Sign)block;
        
        ItemStack diams = new ItemStack(Material.DIAMOND, Integer.valueOf(sign.getLine(2)));
        ItemStack apple = new ItemStack(Material.APPLE, Integer.valueOf(sign.getLine(2)));
        ItemStack appleG = new ItemStack(Material.GOLDEN_APPLE, Integer.valueOf(sign.getLine(2)));
        ItemStack head = new ItemStack(Material.SKULL_ITEM, Integer.valueOf(sign.getLine(2)), (byte) 3);
        ItemStack beacon = new ItemStack(Material.BEACON, Integer.valueOf(sign.getLine(2)));
        ItemStack diamsB = new ItemStack(Material.DIAMOND_BLOCK, Integer.valueOf(sign.getLine(2)));
        ItemStack emerald = new ItemStack(Material.EMERALD, Integer.valueOf(sign.getLine(2)));
        ItemStack emeraldB = new ItemStack(Material.EMERALD_BLOCK, Integer.valueOf(sign.getLine(2)));
        ItemStack sable = new ItemStack(Material.SAND, Integer.valueOf(sign.getLine(2)));
        ItemStack epee = new ItemStack(Material.DIAMOND_SWORD, Integer.valueOf(sign.getLine(2)));
        ItemStack houe = new ItemStack(Material.DIAMOND_HOE, Integer.valueOf(sign.getLine(2)));
        ItemStack spade = new ItemStack(Material.DIAMOND_SPADE, Integer.valueOf(sign.getLine(2)));
        ItemStack hache = new ItemStack(Material.DIAMOND_AXE, Integer.valueOf(sign.getLine(2)));
        ItemStack pioche = new ItemStack(Material.DIAMOND_PICKAXE, Integer.valueOf(sign.getLine(2)));
        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, Integer.valueOf(sign.getLine(2)));
        ItemStack chestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE, Integer.valueOf(sign.getLine(2)));
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, Integer.valueOf(sign.getLine(2)));
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, Integer.valueOf(sign.getLine(2)));
        ItemStack chest = new ItemStack(Material.CHEST, Integer.valueOf(sign.getLine(2)));
        ItemStack furnace = new ItemStack(Material.FURNACE, Integer.valueOf(sign.getLine(2)));
        ItemStack redstone = new ItemStack(Material.REDSTONE, Integer.valueOf(sign.getLine(2)));
        ItemStack anvil = new ItemStack(Material.ANVIL, Integer.valueOf(sign.getLine(2)));
        ItemStack exp = new ItemStack(Material.EXP_BOTTLE, Integer.valueOf(sign.getLine(2)));
        ItemStack armorstand = new ItemStack(Material.ARMOR_STAND, Integer.valueOf(sign.getLine(2)));
        ItemStack bedRock = new ItemStack(Material.BEDROCK, Integer.valueOf(sign.getLine(2)));
        ItemStack bow = new ItemStack(Material.BOW, Integer.valueOf(sign.getLine(2)));
        ItemStack baked_potatoes = new ItemStack(Material.BAKED_POTATO, Integer.valueOf(sign.getLine(2)));
        ItemStack potatoes = new ItemStack(Material.POTATO_ITEM, Integer.valueOf(sign.getLine(2)));
        ItemStack blaze_powder = new ItemStack(Material.BLAZE_POWDER, Integer.valueOf(sign.getLine(2)));
        ItemStack iron = new ItemStack(Material.IRON_INGOT, Integer.valueOf(sign.getLine(2)));
        ItemStack gold = new ItemStack(Material.GOLD_INGOT, Integer.valueOf(sign.getLine(2)));
        ItemStack lapis = new ItemStack(Material.LAPIS_BLOCK, Integer.valueOf(sign.getLine(2)));
        ItemStack wood = new ItemStack(Material.WOOD, Integer.valueOf(sign.getLine(2)));
        ItemStack book = new ItemStack(Material.BOOK, Integer.valueOf(sign.getLine(2)));
        ItemStack command_block = new ItemStack(Material.COMMAND, Integer.valueOf(sign.getLine(2)));
        ItemStack blaze_rod = new ItemStack(Material.BLAZE_ROD, Integer.valueOf(sign.getLine(2)));
        ItemStack coal = new ItemStack(Material.COAL, Integer.valueOf(sign.getLine(2)));
        ItemStack coalB = new ItemStack(Material.COAL_BLOCK, Integer.valueOf(sign.getLine(2)));
        ItemStack wheat = new ItemStack(Material.WHEAT, Integer.valueOf(sign.getLine(2)));
        ItemStack shulker_box = new ItemStack(Material.BLACK_SHULKER_BOX, Integer.valueOf(sign.getLine(2)));
        ItemStack chorus_fruit = new ItemStack(Material.CHORUS_FRUIT, Integer.valueOf(sign.getLine(2)));
        ItemStack chorus_flower = new ItemStack(Material.CHORUS_FLOWER, Integer.valueOf(sign.getLine(2)));
        ItemStack stick = new ItemStack(Material.STICK, Integer.valueOf(sign.getLine(2)));
        ItemStack carrot = new ItemStack(Material.CARROT_ITEM, Integer.valueOf(sign.getLine(2)));
        ItemStack signB = new ItemStack(Material.WALL_SIGN, Integer.valueOf(sign.getLine(2)));
        ItemStack obsidian = new ItemStack(Material.OBSIDIAN, Integer.valueOf(sign.getLine(2)));
        ItemStack lever = new ItemStack(Material.LEVER, Integer.valueOf(sign.getLine(2)));
        ItemStack torche_red = new ItemStack(Material.REDSTONE_TORCH_OFF, Integer.valueOf(sign.getLine(2)));
        ItemStack torche = new ItemStack(Material.TORCH, Integer.valueOf(sign.getLine(2)));
        ItemStack trapped_chest = new ItemStack(Material.TRAPPED_CHEST, Integer.valueOf(sign.getLine(2)));
        ItemStack door = new ItemStack(Material.BIRCH_DOOR, Integer.valueOf(sign.getLine(2)));
        ItemStack water_bucket = new ItemStack(Material.WATER_BUCKET, 1);
        ItemStack lava_bucket = new ItemStack(Material.LAVA_BUCKET, 1);
        ItemStack milk_bucket = new ItemStack(Material.MILK_BUCKET, 1);
        ItemStack tnt = new ItemStack(Material.TNT, Integer.valueOf(sign.getLine(2)));
        ItemStack piston = new ItemStack(Material.PISTON_BASE, Integer.valueOf(sign.getLine(2)));
        ItemStack sticky_piston = new ItemStack(Material.PISTON_STICKY_BASE, Integer.valueOf(sign.getLine(2)));
        ItemStack minecart = new ItemStack(Material.MINECART, Integer.valueOf(sign.getLine(2)));
        ItemStack boat = new ItemStack(Material.BOAT, Integer.valueOf(sign.getLine(2)));
        
        
        SkullMeta skullM = (SkullMeta)head.getItemMeta();
        ItemMeta bowM = bow.getItemMeta();
        ItemMeta epeeM = epee.getItemMeta();
        
        epeeM.addEnchant(Enchantment.DAMAGE_ALL, Integer.MAX_VALUE, true);
        epeeM.setDisplayName("§4épée §2Divine");
        epeeM.setUnbreakable(true);
        epeeM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        skullM.setOwner(player.getName());
        bowM.addEnchant(Enchantment.ARROW_DAMAGE, Integer.MAX_VALUE, true);
        bowM.addEnchant(Enchantment.DAMAGE_ALL, Integer.MAX_VALUE, true);
        bowM.addEnchant(Enchantment.ARROW_FIRE, Integer.MAX_VALUE, true);
        bowM.addEnchant(Enchantment.ARROW_INFINITE, Integer.MAX_VALUE, true);
        bowM.addEnchant(Enchantment.ARROW_KNOCKBACK, Integer.MAX_VALUE, true);
        
        head.setItemMeta(skullM);
        epee.setItemMeta(epeeM);
        bow.setItemMeta(bowM);
        
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && block instanceof Sign)
        {
            
            if(sign.getLine(0).equalsIgnoreCase("[GIVE]"))
            {
                switch(sign.getLine(1))
                {
                    case "Diamant":
                        player.getInventory().addItem(diams);
                        break;
                    case "Apple":
                        player.getInventory().addItem(apple);
                        break;
                    case "Golden_Apple":
                        player.getInventory().addItem(appleG);
                        break;
                    case "Head":
                        player.getInventory().addItem(head);
                        break;
                    case "Beacon":
                        player.getInventory().addItem(beacon);
                        break;
                    case "Diamon_Block":
                        player.getInventory().addItem(diamsB);
                        break;
                    case "Emeraud":
                        player.getInventory().addItem(emerald);
                        break;
                    case "Emeraud_Block":
                        player.getInventory().addItem(emeraldB);
                        break;
                    case "EXP":
                        player.setExp(player.getExp() + new Random().nextInt((int)99999999L));
                        break;
                    case "Sable":
                        player.getInventory().addItem(sable);
                        break;
                    case "Epee":
                        player.getInventory().addItem(epee);
                        break;
                    case "Houe":
                        player.getInventory().addItem(houe);
                        break;
                    case "Pelle":
                        player.getInventory().addItem(spade);
                        break;
                    case "Hache":
                        player.getInventory().addItem(hache);
                        break;
                    case "Pioche":
                        player.getInventory().addItem(pioche);
                        break;
                    case "Arc":
                        player.getInventory().addItem(bow);
                        break;
                    case "Coffre":
                        player.getInventory().addItem(chest);
                        break;
                    case "Fourneau":
                        player.getInventory().addItem(furnace);
                        break;
                    case "Casque":
                        player.getInventory().addItem(helmet);
                        break;
                    case "Plastron":
                        player.getInventory().addItem(chestPlate);
                        break;
                    case "Jambieres":
                        player.getInventory().addItem(leggings);
                        break;
                    case "Bottes":
                        player.getInventory().addItem(boots);
                        break;
                    case "Redstone":
                        player.getInventory().addItem(redstone);
                        break;
                    case "Exp_Bootles":
                        player.getInventory().addItem(exp);
                        break;
                    case "Lapis_Lazuli":
                        player.getInventory().addItem(lapis);
                        break;
                    case "Fer":
                        player.getInventory().addItem(iron);
                        break;
                    case "Or":
                        player.getInventory().addItem(gold);
                        break;
                    case "Bois":
                        player.getInventory().addItem(wood);
                        break;
                    case "Livre":
                        player.getInventory().addItem(book);
                        break;
                    case "Porte_Armure":
                        player.getInventory().addItem(armorstand);
                        break;
                    case "Poudre_De_Blaze":
                        player.getInventory().addItem(blaze_powder);
                        break;
                    case "Patates":
                        player.getInventory().addItem(potatoes);
                        break;
                    case "Patates_Cuite":
                        player.getInventory().addItem(baked_potatoes);
                        break;
                    case "BedRock":
                        player.getInventory().addItem(bedRock);
                        break;
                    case "Enclume":
                        player.getInventory().addItem(anvil);
                        break;
                    case "Command_Block":
                        player.getInventory().addItem(command_block);
                        break;
                    case "Baton_De_Blaze":
                        player.getInventory().addItem(blaze_rod);
                        break;
                    case "Charbon":
                        player.getInventory().addItem(coal);
                        break;
                    case "Block_De_Charbon":
                        player.getInventory().addItem(coalB);
                        break;
                    case "Blé":
                        player.getInventory().addItem(wheat);
                        break;
                    case "Shulker_Box":
                        player.getInventory().addItem(shulker_box);
                        break;
                    case "Fruit_Du_Chorus":
                        player.getInventory().addItem(chorus_fruit);
                        break;
                    case "Fleur_Du_Chorus":
                        player.getInventory().addItem(chorus_flower);
                        break;
                    case "Baton":
                        player.getInventory().addItem(stick);
                        break;
                    case "Carrote":
                        player.getInventory().addItem(carrot);
                        break;
                    case "Pancarte":
                        player.getInventory().addItem(signB);
                        break;
                    case "Obsidienne":
                        player.getInventory().addItem(obsidian);
                        break;
                    case "Levier":
                        player.getInventory().addItem(lever);
                        break;
                    case "Torche_A_Redstone":
                        player.getInventory().addItem(torche_red);
                        break;
                    case "Torche":
                        player.getInventory().addItem(torche);
                        break;
                    case "Coffre_Pieger":
                        player.getInventory().addItem(trapped_chest);
                        break;
                    case "Porte":
                        player.getInventory().addItem(door);
                        break;
                    case "Seau_D'eau":
                        player.getInventory().addItem(water_bucket);
                        break;
                    case "Seau_De_Lave":
                        player.getInventory().addItem(lava_bucket);
                        break;
                    case "Seau_De_Lait":
                        player.getInventory().addItem(milk_bucket);
                        break;
                    case "TNT":
                        player.getInventory().addItem(tnt);
                        break;
                    case "Piston":
                        player.getInventory().addItem(piston);
                        break;
                    case "Piston_Collant":
                        player.getInventory().addItem(sticky_piston);
                        break;
                    case "Wagonnet":
                        player.getInventory().addItem(minecart);
                        break;
                    case "Barque":
                        player.getInventory().addItem(boat);
                        break;                    
                }
            }
        }
    }

}
