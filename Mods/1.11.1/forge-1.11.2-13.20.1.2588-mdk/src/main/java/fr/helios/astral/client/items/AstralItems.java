package fr.helios.astral.client.items;

import fr.helios.astral.References;
import fr.helios.astral.client.blocks.AstralBlocks;
import fr.helios.astral.client.blocks.BlockAstral;
import fr.helios.astral.client.items.metadata.ItemBlockMetadata;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//@EventBusSubscriber(value = Side.CLIENT, modid = References.MODID)
public class AstralItems
{
    public static final Item astral_wand = new ItemAstral();
    public static final Item escalier_de_lumiereitem = new ItemBlock(AstralBlocks.escalier_de_lumiere).setRegistryName(AstralBlocks.escalier_de_lumiere.getRegistryName());
    //public static final Item luminous_crafting_tableitem = new ItemBlockMetadata(AstralBlocks.luminous_crafting_table, new String[] {"astral_block", "astral_block_m1"}).setRegistryName(AstralBlocks.luminous_crafting_table.getRegistryName());
    
    public static void setItemName(Item item, String name)//Enregistre le nom des items.
    {
        item.setRegistryName(References.MODID, name).setUnlocalizedName("astral_wand");
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerItemsModels()//Appelle la fonction qui enregistre les models des item.
    {
        registerModel(astral_wand, 0);
        registerModel(escalier_de_lumiereitem, 0);
        /*for(int i = 0; i < BlockAstral.EnumType.values().length; i++)
            registerModel(luminous_crafting_tableitem, i);*/
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, int metadata)//Enregistre les models(.JSON).
    {
        if(metadata < 0) metadata = 0;
        String resourceName = item.getUnlocalizedName().substring(5).replace(".", ":");
        if(metadata > 0) resourceName += "_m" + String.valueOf(metadata);
        
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(References.MODID + ":" + resourceName, "inventory"));
    }
}
