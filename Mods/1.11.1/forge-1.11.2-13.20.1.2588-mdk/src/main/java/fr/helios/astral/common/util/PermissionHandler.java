package fr.helios.astral.common.util;

import java.util.Collection;

import com.mojang.authlib.GameProfile;

import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.IPermissionHandler;
import net.minecraftforge.server.permission.context.IContext;

public class PermissionHandler implements IPermissionHandler
{
    @Override
    public void registerNode(String node, DefaultPermissionLevel level, String desc)
    {
        
    }
    
    @Override
    public Collection<String> getRegisteredNodes()
    {
        return null;
    }
    
    public boolean hasPermission(GameProfile profile, String node, IContext context) 
    {
        return false;
    }

    @Override
    public String getNodeDescription(String node)
    {
        return null;
    }
}
