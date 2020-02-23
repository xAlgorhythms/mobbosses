package me.xalgorhythms.mobbosses.Listeners;

import me.xalgorhythms.mobbosses.BossRegions.BossRegion;
import me.xalgorhythms.mobbosses.Files.Regions;
import me.xalgorhythms.mobbosses.Main;
import me.xalgorhythms.mobbosses.Utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import static me.xalgorhythms.mobbosses.Files.RegionMapStorage.fightersList;
import static me.xalgorhythms.mobbosses.Files.RegionMapStorage.regionMap;


public class PlayerInRegion implements Listener {

	Plugin plugin = Main.getPlugin(Main.class);

	private String bossName;
	private BossRegion region;
	private String bossRegionName;
	//private static ArrayList<Player> fighters;

	@EventHandler
	public void onEnterBossRegion(PlayerMoveEvent e) {


		Player player = e.getPlayer();

		// Gets all boss regions
		for (Map.Entry<String, BossRegion> entry1 : regionMap.entrySet()) {
			bossName = entry1.getKey();
			region = entry1.getValue();

			// Gets all arraylists for the corresponding boss regions
			for (Map.Entry<String, ArrayList> entry2 : fightersList.entrySet()) {
				bossRegionName = entry2.getKey();
				ArrayList<Player> fighters = entry2.getValue();

				if (region != null) {

					// If the player is not in any region
					if (!(region.isInRegion(player))) {
						if (fighters.isEmpty()) {
							return;
						} else if (fighters.contains(player)) {
							fighters.remove(player);
							player.sendMessage(Utils.chat("&3You have left &b" + bossRegionName));
						}

					// If the player is in a specified region
					} else if (region.isInRegion(player)) {
						if (fighters.isEmpty() || !(fighters.contains(player))) {
							fighters.add(player);
							player.sendMessage(Utils.chat("&3You have entered &b" + bossRegionName));
						}
					}
				}
			}
		}



				/*Zombie zombieBoss = (Zombie) e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.ZOMBIE);
				String bossName = plugin.getConfig().getString("Bosses.ZombieBoss.Name");
				boolean nameVisibility = plugin.getConfig().getBoolean("Bosses.ZombieBoss.NameIsVisible");
				double maxHealth = plugin.getConfig().getDouble("Bosses.ZombieBoss.MaxHealth");
				double movementSpeed = plugin.getConfig().getDouble("Bosses.ZombieBoss.MovementSpeed");
				double attackDamage = plugin.getConfig().getDouble("Bosses.ZombieBoss.AttackDamage");
				double knockbackResistance = plugin.getConfig().getDouble("Bosses.ZombieBoss.KnockbackResistance");
				double reward = plugin.getConfig().getDouble("Bosses.ZombieBoss.Reward");

				zombieBoss.setGlowing(nameVisibility);
				zombieBoss.setCustomName(bossName);
				zombieBoss.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
				zombieBoss.setHealth(zombieBoss.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
				zombieBoss.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(attackDamage);
				zombieBoss.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(movementSpeed);
				zombieBoss.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(knockbackResistance);

				zombieBoss.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
				zombieBoss.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
				zombieBoss.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
				zombieBoss.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));*/

	}

	/*public void onBossDeath(EntityDeathEvent e) {

	}*/

}


