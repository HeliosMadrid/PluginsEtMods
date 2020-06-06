package com.helios.mod.init;

import com.helios.mod.References;
import com.helios.mod.items.ItemArmorASTRAL;
import com.helios.mod.items.ItemMod;
import com.helios.mod.items.PickaxeMod;
import com.helios.mod.items.SwordMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemsMod
{
    public static ToolMaterial TOOLASTRAL = EnumHelper.addToolMaterial("TOOLASTRAL", 3, 10000, 100.0F, 50.0F, 50);
    public static ArmorMaterial ARMORASTRAL = EnumHelper.addArmorMaterial("ARMORASTRAL", "ARMORASTRAL", 1000, new int[]{8, 16, 14, 10}, 50, SoundEvents.ENTITY_BLAZE_SHOOT, 50.0F);
    
    public static Item fragementLunaire, epeeLune, piocheLune, casqueLune, plastronLune, jambieresLune, botesLune;
    
    public static void init()
    {
        fragementLunaire = new ItemMod().setUnlocalizedName("fragementLunaire").setCreativeTab(CreativeTabs.TOOLS);
        epeeLune = new SwordMod(TOOLASTRAL).setUnlocalizedName("epeeLune").setCreativeTab(CreativeTabs.COMBAT);
        piocheLune = new PickaxeMod(TOOLASTRAL).setUnlocalizedName("piocheLune").setCreativeTab(CreativeTabs.TOOLS);
        casqueLune = new ItemArmorASTRAL(ARMORASTRAL, EntityEquipmentSlot.HEAD).setUnlocalizedName("casqueLune").setCreativeTab(CreativeTabs.COMBAT);
        plastronLune = new ItemArmorASTRAL(ARMORASTRAL, EntityEquipmentSlot.CHEST).setUnlocalizedName("plastronLune").setCreativeTab(CreativeTabs.COMBAT);
        jambieresLune = new ItemArmorASTRAL(ARMORASTRAL, EntityEquipmentSlot.LEGS).setUnlocalizedName("jambieresLune").setCreativeTab(CreativeTabs.COMBAT);
        botesLune = new ItemArmorASTRAL(ARMORASTRAL, EntityEquipmentSlot.FEET).setUnlocalizedName("botesLune").setCreativeTab(CreativeTabs.COMBAT);

    }
    
    public static void register()
    {
        GameRegistry.registerItem(fragementLunaire, fragementLunaire.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(epeeLune, epeeLune.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(piocheLune, piocheLune.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(casqueLune, casqueLune.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(plastronLune, plastronLune.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(jambieresLune, jambieresLune.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(botesLune, botesLune.getUnlocalizedName().substring(5));

}
    
    public static void registerRenders()
    {
        registerRender(fragementLunaire);
        registerRender(epeeLune);
        registerRender(piocheLune);
        registerRender(casqueLune);
        registerRender(plastronLune);
        registerRender(jambieresLune);
        registerRender(botesLune);

    }
    private static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(References.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));  
    }
}
