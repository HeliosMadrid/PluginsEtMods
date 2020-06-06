package fr.helios.divin.blocks;

import fr.helios.divin.ModDivin;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DivinBlocks
{
    public static final Block magicalSteam = new MagicalSteamBlock(Material.rock).setUnlocalizedName("magicalSteam").setCreativeTab(CreativeTabs.tabCombat).setHardness(50.0F).setResistance(1.0F).setLightLevel(1.0F);
    public static final Block catalyseurDePuissance = new CatalyseurDePuissance(Material.rock);
    
    @SideOnly(Side.CLIENT)
    public static void registerBlock()
    {
        GameRegistry.registerBlock(magicalSteam, "magicalSteam");
        GameRegistry.registerBlock(catalyseurDePuissance, "catalyseurDePuissance");
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerItemFromBlock()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(magicalSteam), 0, new ModelResourceLocation(ModDivin.MODID + ":magicalSteam", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(catalyseurDePuissance), 0, new ModelResourceLocation(ModDivin.MODID + ":catalyseurDePuissance", "inventory"));
    }

}
