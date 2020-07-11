package fr.helios.stplugin.entity.projectile;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pose;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

public class LaserBase implements Projectile
{
	protected final byte id;
	protected final UUID uuid;
	protected final String name;
	protected final boolean bounce;
	
	public LaserBase(byte id, UUID uuid, String name, boolean bounce) {
		this.id = id;
		this.uuid = uuid;
		this.name = name;
		this.bounce = bounce;
	}

    @Override
    public boolean addPassenger(Entity entity)
    {
        return false;
    }

    @Override
    public boolean addScoreboardTag(String string)
    {
        return false;
    }

    @Override
    public boolean eject()
    {
        return false;
    }

    @Override
    public BoundingBox getBoundingBox()
    {
        return new BoundingBox(7, 7, 7, 8, 8, 8);
    }

    @Override
    public int getEntityId()
    {
        return this.id;
    }

    @Override
    public BlockFace getFacing()
    {
        return BlockFace.NORTH;
    }

    @Override
    public float getFallDistance()
    {
        return 0;
    }

    @Override
    public int getFireTicks()
    {
        return 20 * 1000;
    }

    @Override
    public double getHeight()
    {
        return 1;
    }

    @Override
    public EntityDamageEvent getLastDamageCause()
    {
        return null;
    }

    @Override
    public Location getLocation()
    {
        return null;
    }

    @Override
    public Location getLocation(Location arg0)
    {
        return null;
    }

    @Override
    public int getMaxFireTicks()
    {
        return 20 * 1000;
    }

    @Override
    public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2)
    {
        return null;
    }

    @Override
    public Entity getPassenger()
    {
        return null;
    }

    @Override
    public List<Entity> getPassengers()
    {
        return null;
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction()
    {
        return PistonMoveReaction.MOVE;
    }

    @Override
    public int getPortalCooldown()
    {
        return 20;
    }

    @Override
    public Pose getPose()
    {
        return Pose.SPIN_ATTACK;
    }

    @Override
    public Set<String> getScoreboardTags()
    {
        return null;
    }

    @Override
    public Server getServer()
    {
        return null;
    }

    @Override
    public int getTicksLived()
    {
        return 0;
    }

    @Override
    public EntityType getType()
    {
        return EntityType.ARROW;
    }

    @Override
    public UUID getUniqueId()
    {
        return this.uuid;
    }

    @Override
    public Entity getVehicle()
    {
        return null;
    }

    @Override
    public Vector getVelocity()
    {
        return new Vector();
    }

    @Override
    public double getWidth()
    {
        return 1;
    }

    @Override
    public World getWorld()
    {
        return Bukkit.getWorld("world");
    }

    @Override
    public boolean hasGravity()
    {
        return false;
    }

    @Override
    public boolean isCustomNameVisible()
    {
        return false;
    }

    @Override
    public boolean isDead()
    {
        return false;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public boolean isGlowing()
    {
        return true;
    }

    @Override
    public boolean isInsideVehicle()
    {
        return false;
    }

    @Override
    public boolean isInvulnerable()
    {
        return true;
    }

    @Override
    public boolean isOnGround()
    {
        return false;
    }

    @Override
    public boolean isPersistent()
    {
        return true;
    }

    @Override
    public boolean isSilent()
    {
        return true;
    }

    @Override
    public boolean isValid()
    {
        return true;
    }

    @Override
    public boolean leaveVehicle()
    {
        return false;
    }

    @Override
    public void playEffect(EntityEffect arg0)
    {

    }

    @Override
    public void remove()
    {

    }

    @Override
    public boolean removePassenger(Entity arg0)
    {
        return false;
    }

    @Override
    public boolean removeScoreboardTag(String arg0)
    {
        return false;
    }

    @Override
    public void setCustomNameVisible(boolean arg0)
    {

    }

    @Override
    public void setFallDistance(float arg0)
    {

    }

    @Override
    public void setFireTicks(int arg0)
    {

    }

    @Override
    public void setGlowing(boolean arg0)
    {

    }

    @Override
    public void setGravity(boolean arg0)
    {

    }

    @Override
    public void setInvulnerable(boolean arg0)
    {

    }

    @Override
    public void setLastDamageCause(EntityDamageEvent arg0)
    {

    }

    @Override
    public boolean setPassenger(Entity arg0)
    {
        return false;
    }

    @Override
    public void setPersistent(boolean arg0)
    {

    }

    @Override
    public void setPortalCooldown(int arg0)
    {

    }

    @Override
    public void setRotation(float arg0, float arg1)
    {

    }

    @Override
    public void setSilent(boolean arg0)
    {

    }

    @Override
    public void setTicksLived(int arg0)
    {

    }

    @Override
    public void setVelocity(Vector arg0)
    {

    }

    @Override
    public Spigot spigot()
    {
        return null;
    }

    @Override
    public boolean teleport(Location arg0)
    {
        return false;
    }

    @Override
    public boolean teleport(Entity arg0)
    {
        return false;
    }

    @Override
    public boolean teleport(Location arg0, TeleportCause arg1)
    {
        return false;
    }

    @Override
    public boolean teleport(Entity arg0, TeleportCause arg1)
    {
        return false;
    }

    @Override
    public List<MetadataValue> getMetadata(String arg0)
    {
        return null;
    }

    @Override
    public boolean hasMetadata(String arg0)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeMetadata(String arg0, Plugin arg1)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setMetadata(String arg0, MetadataValue arg1)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void sendMessage(String arg0)
    {

    }

    @Override
    public void sendMessage(String[] arg0)
    {

    }

    @Override
    public PermissionAttachment addAttachment(Plugin arg0)
    {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin arg0, int arg1)
    {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2, int arg3)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasPermission(String arg0)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasPermission(Permission arg0)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPermissionSet(String arg0)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPermissionSet(Permission arg0)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void recalculatePermissions()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeAttachment(PermissionAttachment arg0)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isOp()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setOp(boolean arg0)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCustomName()
    {
        return this.name;
    }

    @Override
    public void setCustomName(String arg0)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public PersistentDataContainer getPersistentDataContainer()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean doesBounce()
    {
        return this.bounce;
    }

    @Override
    public ProjectileSource getShooter()
    {
        return null;
    }

    @Override
    public void setBounce(boolean arg0)
    {

    }

    @Override
    public void setShooter(ProjectileSource arg0)
    {

    }

}
