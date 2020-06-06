package fr.helios.astral.utils;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.helios.astral.ModAstral;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class AstralCreativeTab extends CreativeTabs
{
    List list;

    public AstralCreativeTab(String label)
    {
        super(label);
    }

    @Override
    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(ModAstral.coffre_astral);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_151243_f()
    {
        return 0;
    }
    
    @Override
    public void displayAllReleventItems(List list)
    {
        this.list = list;
        
        addBlock(ModAstral.coffre_astral);
        addBlock(ModAstral.gemme);
        addBlock(ModAstral.crystal_astrale);
        addBlock(ModAstral.fragement_etoile);
        addBlock(ModAstral.lumiere_pur);
        addBlock(ModAstral.souffleur);
        addItem(ModAstral.luminous_wand);
        addItem(ModAstral.sword_astral);
        addItem(ModAstral.axe_astral);
        addItem(ModAstral.hoe_astral);
        addItem(ModAstral.pickaxe_astral);
        addItem(ModAstral.shovel_astral);
        addItem(ModAstral.helmet_astral);
        addItem(ModAstral.chestpalte_astral);
        addItem(ModAstral.leggings_astral);
        addItem(ModAstral.boots_astral);
        addItem(ModAstral.gemmes);
    }
    
    private void addItem(Item item)
    {
        item.getSubItems(item, this, list);
    }
    
    private void addBlock(Block block)
    {
        block.getSubBlocks(Item.getItemFromBlock(block), this, list);
    }

    @Override
    public boolean hasSearchBar()
    {
        return true;
    }

}
