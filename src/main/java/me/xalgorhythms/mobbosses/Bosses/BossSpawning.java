package me.xalgorhythms.mobbosses.Bosses;

import me.xalgorhythms.mobbosses.Main;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import java.util.*;

public class BossSpawning extends Event {

	private static final HandlerList handlers = new HandlerList();

	Plugin plugin = Main.getPlugin(Main.class);

	Random rand = new Random();

	Zombie zomBoss;
	Location loc;

	public BossSpawning(Zombie zomBoss,Location loc){

	}

	@EventHandler
	public void onMobSpawn(EntitySpawnEvent e) {

		Entity entity = e.getEntity();

		if (entity.getType() == EntityType.ZOMBIE && rand.nextInt(100) < 3) {
			return;
			/*Zombie zombieBoss = (Zombie) e.getEntity();

			// Parameters here
			//zombieBoss.setMaxHealth(100.0);
			zombieBoss.setGlowing(true);
			zombieBoss.setCustomName("Super Mega \"Do not fuck with me\" Zombie");
			zombieBoss.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
			zombieBoss.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			zombieBoss.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
			zombieBoss.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
			zombieBoss.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(200.0);
			zombieBoss.setHealth(zombieBoss.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			zombieBoss.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(10.0);
			zombieBoss.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(1.5);
			zombieBoss.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(10.0);*/


		}

	}


	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}




}
