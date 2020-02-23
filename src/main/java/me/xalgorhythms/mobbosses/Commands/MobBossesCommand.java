package me.xalgorhythms.mobbosses.Commands;

import me.xalgorhythms.mobbosses.BossRegions.BossRegion;
import me.xalgorhythms.mobbosses.Files.BossList;
import me.xalgorhythms.mobbosses.Files.RegionMapStorage;
import me.xalgorhythms.mobbosses.Files.Regions;
import me.xalgorhythms.mobbosses.Main;
import me.xalgorhythms.mobbosses.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static me.xalgorhythms.mobbosses.Files.RegionMapStorage.regionMap;
import static me.xalgorhythms.mobbosses.Files.RegionMapStorage.fightersList;
import static me.xalgorhythms.mobbosses.Files.RegionMapStorage.locMap;
import static me.xalgorhythms.mobbosses.Files.RegionMapStorage.regionLocMap;
import static me.xalgorhythms.mobbosses.Files.RegionMapStorage.loc1List;
import static me.xalgorhythms.mobbosses.Files.RegionMapStorage.loc2List;



public class MobBossesCommand implements CommandExecutor {

	private String bossName;
	private String bossRegionName;
	private Location loc1;
	private Location loc2;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Plugin plugin = Main.getPlugin(Main.class);

		if (!(sender instanceof Player)) {
			sender.sendMessage("&4You must be a player to use this command!");
		} else {

		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("mobbosses")) {

			/*// Spawn specific boss on command
			if (args[0].equalsIgnoreCase("spawnboss")) {*/

			} else

			/*// Reloads bossRegions.yml and bossList.yml
			if (args[0].equalsIgnoreCase("reload")) {
				//BossList.reload();
				Regions.reload();
				sender.sendMessage(ChatColor.DARK_GREEN + "MobBosses reloaded.");
			} else*/

			// Position setting for boss regions, position 1
			if (args[0].equalsIgnoreCase("setpos1")) {
				if (args.length == 2) {
					bossName = args[1].toUpperCase();
					loc1List.put(bossName, player.getLocation());

					if (loc1List.containsKey(bossName)) {
						player.sendMessage(Utils.chat("&3Position 1 set to "
							+ "&bX: " + player.getLocation().getBlockX()
							+ "&b, Y: " + player.getLocation().getBlockY()
							+ "&b, Z: " + player.getLocation().getBlockZ()
							+ " &3for &b" + bossName.toUpperCase() + " &3region."));
					}

				} else {
					player.sendMessage(Utils.chat("&cUsage: &4/mb setpos1 'bossname'"));
				}
			} else

			// Position setting for boss regions, position 2
			if (args[0].equalsIgnoreCase("setpos2")) {
				if (args.length == 2) {
					bossName = args[1].toUpperCase();
					loc2List.put(bossName, player.getLocation());

					if (loc2List.containsKey(bossName)) {
						player.sendMessage(Utils.chat("&3Position 2 set to "
							+ "&bX: " + player.getLocation().getBlockX()
							+ "&b, Y: " + player.getLocation().getBlockY()
							+ "&b, Z: " + player.getLocation().getBlockZ()
							+ " &3for &b" + bossName.toUpperCase() + " &3region."));
					}
				} else {
					player.sendMessage(Utils.chat("&cUsage: &4/mb setpos2 'bossname'"));
				}
			}
					/*else

					/*
				// Returns specified boss's position 1 values, if any
				if (args[0].equalsIgnoreCase("getpos1")) {
					if (args.length == 2) {
						String bossName = args[1];
						if (Regions.get().getLocation(bossName.toUpperCase() + ".Pos1") != null) {
							player.sendMessage(Utils.chat("&b" + bossName.toUpperCase()
								+ " &3Region Position 1: X: &b" + Regions.get().getLocation(bossName.toUpperCase() + ".Pos1").getBlockX()
								+ "&3, Y: &b" + Regions.get().getLocation(bossName.toUpperCase() + ".Pos1").getBlockY()
								+ "&3, Z: &b" + Regions.get().getLocation(bossName.toUpperCase() + ".Pos1").getBlockZ()));
						} else {
							player.sendMessage(Utils.chat("&cNo values found for &4" + bossName + " &cposition 1"));
						}
					} else {
						player.sendMessage(Utils.chat("&cUsage: &4/mb getpos1 'bossname'"));
					}
				} else

				// Returns specified boss's position 2 values, if any
				if (args[0].equalsIgnoreCase("getpos2")) {
					if (args.length == 2) {
						String bossName = args[1];
						if (Regions.get().getLocation(bossName.toUpperCase() + ".Pos2") != null) {
							player.sendMessage(Utils.chat("&b" + bossName.toUpperCase()
									+ " &3Region Position 2: X: &b" + Regions.get().getLocation(bossName.toUpperCase() + ".Pos2").getBlockX()
									+ "&3, Y: &b" + Regions.get().getLocation(bossName.toUpperCase() + ".Pos2").getBlockY()
									+ "&3, Z: &b" + Regions.get().getLocation(bossName.toUpperCase() + ".Pos2").getBlockZ()));
						} else {
							player.sendMessage(Utils.chat("&cNo values found for &4" + bossName + " &cposition 2"));
						}
					} else {
						player.sendMessage(Utils.chat("&cUsage: &4/mb getpos2 'bossname'"));
				}*/ else


			// Creates the boss region for the specified boss, using already specified corner positions for the region
			if (args[0].equalsIgnoreCase("region")) {
				if (args[1].equalsIgnoreCase("create")) {
					if (args.length == 3) {
						bossName = args[2].toUpperCase();
						bossRegionName = bossName + "_Region";

						loc1 = loc1List.get(bossName);
						loc2 = loc2List.get(bossName);

						if (loc1 != null && loc2 != null) {
							regionMap.put(bossRegionName, new BossRegion(loc1, loc2));
							fightersList.put(bossRegionName, new ArrayList<Player>());

							//RegionMapStorage.save();
							player.sendMessage(Utils.chat("&3Region has successfully been created for &b" + bossName));
						} else {
							player.sendMessage(Utils.chat("&cYou must first set positions 1 and 2 with &4/mb setpos1 'bossname' &cand &4/mb setpos2 'bossname' &ccommands."));
						}
					} else if (args.length != 3) {
						player.sendMessage(Utils.chat("&cUsage: &4/mb region create 'bossname' &cafter setting positions 1 and 2"));
					}
				} else {
					player.sendMessage(Utils.chat("&cUsage: &4/mb region create 'bossname' &cafter setting positions 1 and 2"));
				}
			} else

			// Checks contents of regionMap
			if (args[0].equalsIgnoreCase("rgmap")) {
				for (Map.Entry<String, BossRegion> entry : regionMap.entrySet()) {
					String regionName = entry.getKey();
					String bossRegions = entry.getValue().toString();
					player.sendMessage(Utils.chat("&3Region List: &b" + regionName + ", " + bossRegions));
				}

			}
		} //else {
			//player.sendMessage(Utils.chat("&cUnknown command."));
		//} return false;

		return false;
	}}



