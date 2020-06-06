package fr.helios.vault;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import fr.helios.vault.listener.VaultListener;

public class Vault extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        super.onEnable();
        Bukkit.getPluginManager().registerEvents(new VaultListener(), this);
    }
}
