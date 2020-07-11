package fr.helios.stplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ComCommand implements CommandExecutor, Listener {
	
	private final Inventory menu = Bukkit.createInventory(null, 9, "Note");
	private final Inventory chestCommon = Bukkit.createInventory(null, 54, "inventaire commun");
	private final Inventory collectionMobs = Bukkit.createInventory(null, 54, "Créatures découvertes");
	private boolean isPrepare = false;
 	
	ItemStack
	book = new ItemStack(Material.WRITABLE_BOOK),
	chest = new ItemStack(Material.CHEST),
	headZom = new ItemStack(Material.ZOMBIE_HEAD);
	
	ItemMeta 
	bookM = book.getItemMeta(),
	chestM = chest.getItemMeta(),
	headZomM = headZom.getItemMeta();
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		prepareMenu();
		
		Player player = (Player) sender;
		
		player.openInventory(menu);
		
		return true;
	}
	
	@EventHandler
	public void comNote(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		
		if(event.getCurrentItem().getType() == Material.CHEST && event.getCurrentItem().getItemMeta().getDisplayName().equals("§aInventaire commun")) {
			event.setCancelled(true);
			player.openInventory(chestCommon);
		} else if(event.getCurrentItem().getType() == Material.ZOMBIE_HEAD && event.getCurrentItem().getItemMeta().getDisplayName().equals("§6Escpeces découvertes")) {
			event.setCancelled(true);
			prepareMobs();
			player.openInventory(collectionMobs);
		}
	}
	
	private void prepareMenu() {
		if(!isPrepare) {
			bookM.setDisplayName("§2Note pour USS Enterprise");
			chestM.setDisplayName("§aInventaire commun");
			headZomM.setDisplayName("§6Escpeces découvertes");
			
			book.setItemMeta(bookM);
			chest.setItemMeta(chestM);
			headZom.setItemMeta(headZomM);
			
			menu.setItem(0, book);
			menu.setItem(5, headZom);
			menu.setItem(8, chest);
			this.isPrepare = true;
		}
	}
	
	private void prepareMobs() {
		for(int i = 0; i < 54; i++) {
			switch(i) {
				case 0:
					RGB(true, "Âne");
					break;

				case 1:
					RGB(true , "Arpenteur");
					break;

				case 2:
					RGB(true , "Champimeuh");
					break;

				case 3:
					RGB(true , "Champimeuh Brune");
					break;

				case 4:
					RGB(true , "Chat");
					break;

				case 5:
					RGB(true , "Chauve-souris");
					break;

				case 6:
					RGB(true , "Cheval");
					break;

				case 7:
					RGB(true , "Cheval-squelette");
					break;

				case 8:
					RGB(true , "Cochon");
					break;

				case 9:
					RGB(true , "Lapin");
					break;

				case 10:
					RGB(true , "Marchand ambulant");
					break;

				case 11:
					RGB(true , "Morue");
					break;

				case 12:
					RGB(true , "Mouton");
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
					
				case 13:
					
					break;
				
				default: break;
			}
		}
	}
	
	private ItemStack RGB(boolean redOrGreen, String name) {
		if(redOrGreen) {
			ItemStack red = new ItemStack(Material.RED_WOOL);
			ItemMeta redM = red.getItemMeta();
			redM.setDisplayName("§4".concat(name));
			red.setItemMeta(redM);
			return red;
		} else {
			ItemStack green = new ItemStack(Material.RED_WOOL);
			ItemMeta greenM = green.getItemMeta();
			greenM.setDisplayName("§a".concat(name));
			green.setItemMeta(greenM);
			return green;
		}
	}

}
