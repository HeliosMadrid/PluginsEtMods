package fr.helios.asrmorstand;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_12_R1.EntityArmorStand;
import net.minecraft.server.v1_12_R1.EnumItemSlot;
import net.minecraft.server.v1_12_R1.PacketPlayOutEntityEquipment;
import net.minecraft.server.v1_12_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_12_R1.WorldServer;


public class Main extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        getCommand("as").setExecutor(this);
    }
    
    @Override
    public void onDisable()
    {
        
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(label.equalsIgnoreCase("as"))
        {
            if(sender instanceof Player)
            {
                Player player = (Player)sender;
                Location loc = player.getLocation();
                
                //Bukkit
                ArmorStand stand = (ArmorStand)loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
                stand.setArms(true);
                stand.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                stand.setCustomName("§aPetite Entité");
                stand.setCustomNameVisible(true);
                stand.setVisible(false);
                
                //nms packet
                WorldServer server = ((CraftWorld) loc.getWorld()).getHandle();
                EntityArmorStand nmsStand = new EntityArmorStand(server);
                nmsStand.setPositionRotation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
                nmsStand.setCustomName("§cTest");
                nmsStand.setCustomNameVisible(true);
                
                PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(nmsStand);
                ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
                
                ItemStack i = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta iM = i.getItemMeta();
                iM.addEnchant(Enchantment.DURABILITY, 999, true);
                i.setItemMeta(iM);
                PacketPlayOutEntityEquipment packetEquip = new PacketPlayOutEntityEquipment(nmsStand.getId(), EnumItemSlot.CHEST, CraftItemStack.asNMSCopy(i));
                ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packetEquip);
            }
        }
        
        return false;
    }
}
