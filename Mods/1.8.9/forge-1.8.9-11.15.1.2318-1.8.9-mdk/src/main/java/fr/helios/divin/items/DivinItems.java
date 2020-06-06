package fr.helios.divin.items;

import fr.helios.divin.ModDivin;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DivinItems
{
    public static final Item gemmes = new Gemmes().setUnlocalizedName("gemmes").setRegistryName("gemmes").setCreativeTab(CreativeTabs.tabTools);
    
    public static void registerItems()
    {
        GameRegistry.registerItem(gemmes, "gemmes");
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerItemsModels()
    {
        ModelLoader.setCustomModelResourceLocation(gemmes, 0, new ModelResourceLocation(ModDivin.MODID + ":gemmes", "inventory"));
    }
}
