package fr.helios.stplugin.commands.tab;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import com.google.common.collect.Lists;

public class TabPNG implements TabCompleter
{

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args)
    {
        
        switch(args.length) {
            case 0:
                return Lists.newArrayList("Nom Du PNJ");
            case 1: 
                return Lists.newArrayList("Rouge", "Vert", "Bleu", "Jaune", "Rouge Claire", "Or", "Vert Claire", "Aqua", "Aqua Foncé", "Bleu Foncé", "Rose", "Violet", "Blanc", "Gris", "Gris Foncé", "Noir", "Gras", "Italic", "Rayé", "Souligné", "Changeant");
            case 2:
                return Lists.newArrayList("true", "false");
            default: return Lists.newArrayList();
        }
    }

}
