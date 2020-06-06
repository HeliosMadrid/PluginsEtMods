package fr.helios.astral.client.blocks;


import fr.helios.astral.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.Side;

//@EventBusSubscriber(value = Side.CLIENT, modid = References.MODID)
public class AstralBlocks
{
    //public static final Block luminous_crafting_table = new BlockAstral(Material.WOOD);
    public static final Block escalier_de_lumiere = new BlockStairsAstral(Blocks.IRON_BLOCK.getDefaultState());
    
    public static void setBlockName(Block block, String name)
    {
        //block.setRegistryName(References.MODID, name).setUnlocalizedName(/*References.MODID + "." + */name);
        block.setRegistryName(References.MODID, name).setUnlocalizedName(References.MODID + "." + name);
    }
}
