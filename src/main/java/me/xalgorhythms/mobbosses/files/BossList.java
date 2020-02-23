package me.xalgorhythms.mobbosses.files;

import me.xalgorhythms.mobbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.HashMap;

public class BossList {

	static Plugin plugin = Main.getPlugin(Main.class);

	private static File bossFile;
	private static FileConfiguration bossList;

	private static HashMap<String, String> defaults;

	// Finds or generates custom YAML file
	public static void setup() {
		bossFile = new File(Bukkit.getServer().getPluginManager().getPlugin("MobBosses").getDataFolder(), "bosses.yml");

		if (!bossFile.exists()) {
			try {
				bossFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
				plugin.getLogger().warning("Could not create \"bosses.yml\" file.");
			}
		}
		bossList = YamlConfiguration.loadConfiguration(bossFile);
	}



	public static FileConfiguration get() {
		return bossList;
	}

	public static void save() {
		try {
			bossList.save(bossFile);
		} catch (Exception e) {
			e.printStackTrace();
			plugin.getLogger().warning("Could not save \"bossList.yml\" file.");
		}
	}

	public static void reload() {
		try {
			bossList = YamlConfiguration.loadConfiguration(bossFile);
		} catch (Exception e) {
			e.printStackTrace();
			plugin.getLogger().warning("Could not reload \"bossList.yml\" file.");
		}
	}

}
