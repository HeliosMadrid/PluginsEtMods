package com.helios.mod.proxy;

import com.helios.mod.init.BlocksMod;
import com.helios.mod.init.ItemsMod;

public class ClientProxy extends CommonProxy
{   
    @Override
    public void registerRenders()
    {
        BlocksMod.registerRenders();
        ItemsMod.registerRenders();
    }
}
