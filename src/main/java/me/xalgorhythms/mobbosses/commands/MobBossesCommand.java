package me.xalgorhythms.mobbosses.commands;

import me.xalgorhythms.mobbosses.bossregions.BossRegion;
import me.xalgorhythms.mobbosses.Main;
import me.xalgorhythms.mobbosses.files.Regions;
import me.xalgorhythms.mobbosses.utils.Utils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Map;

import static me.xalgorhythms.mobbosses.files.RegionMapStorage.regionMap;
import static me.xalgorhythms.mobbosses.files.RegionMapStorage.fightersList;
import static me.xalgorhythms.mobbosses.files.RegionMapStorage.loc1List;
import static me.xalgorhythms.mobbosses.files.RegionMapStorage.loc2List;

public class MobBossesCommand implements CommandExecutor {

	Plugin plugin = Main.getPlugin(Main.class);

	private String bossName;
	private String bossRegionName;
	private Location loc1;
	private Location loc2;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("mobbosses")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("&4You must be a player to use this command!");
			} else {

				Player player = (Player) sender;

				// Reloads bossRegions.yml and bossList.yml
				if (args[0].equalsIgnoreCase("reload")) {
					//BossList.reload();
					Regions.reload();
					sender.sendMessage(Utils.chat("&aMobBosses reloaded."));
				} else

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
						} else

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
									} else {
										player.sendMessage(Utils.chat("&cUsage: &4/mb region create 'bossname' &cafter setting positions 1 and 2"));
									}
								} else {
									player.sendMessage(Utils.chat("&cUsage: &4/mb region create 'bossname' &cafter setting positions 1 and 2"));
								}
							}
			}
		} else {
			sender.sendMessage(Utils.chat("&cUnknown command."));
		} return false;
	}
}



