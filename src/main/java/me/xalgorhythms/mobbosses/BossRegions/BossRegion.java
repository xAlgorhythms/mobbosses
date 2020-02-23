package me.xalgorhythms.mobbosses.BossRegions;

import me.xalgorhythms.mobbosses.Main;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class BossRegion implements Listener {

	Plugin plugin = Main.getPlugin(Main.class);

	private Location l1;
	private Location l2;

	public BossRegion(Location loc1, Location loc2) {
		World world = loc1.getWorld();
		double x1 = Math.min(loc1.getBlockX(), loc2.getBlockX());
		double y1 = Math.min(loc1.getBlockY(), loc2.getBlockY());
		double z1 = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
		double x2 = Math.max(loc1.getBlockX(), loc2.getBlockX());
		double y2 = Math.max(loc1.getBlockY(), loc2.getBlockY());
		double z2 = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
		this.l1 = new Location(world, x1, y1, z1);
		this.l2 = new Location(world, x2, y2, z2);
	}

	public boolean isInRegion(Player player) {
		return player.getLocation().getBlockX() >= l1.getBlockX() && player.getLocation().getBlockX() <= l2.getBlockX()
			&& player.getLocation().getBlockY() >= l1.getBlockY() && player.getLocation().getBlockY() <= l2.getBlockY()
			&& player.getLocation().getBlockZ() >= l1.getBlockZ() && player.getLocation().getBlockZ() <= l2.getBlockZ();
	}
	
}



