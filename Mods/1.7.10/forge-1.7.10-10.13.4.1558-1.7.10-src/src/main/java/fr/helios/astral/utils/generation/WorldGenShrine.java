package fr.helios.astral.utils.generation;

import java.util.Random;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenShrine extends WorldGenerator
{

    @Override
    public boolean generate(World world, Random random, int x, int y, int z)
    {
        if(world.isAirBlock(x, y + 1, z) && !world.isRemote)
        {
        world.setBlock(x, y, z, Blocks.crafting_table);
        world.setBlock(x, y + 1, z, Blocks.furnace);
        world.setBlock(x, y + 2, z, Blocks.command_block);
        EntityCreeper creeper = new EntityCreeper(world);
        creeper.setPosition(x, y + 3, z);
        world.spawnEntityInWorld(creeper);
        return true;
        }
        return false;
    }

}
