package fr.helios.dragon.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMod extends Block 
{

	public BlockMod(String name, Material materialIn) 
	{
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
}
