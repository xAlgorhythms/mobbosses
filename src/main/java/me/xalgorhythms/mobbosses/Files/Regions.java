package me.xalgorhythms.mobbosses.Files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Regions {

	private static File regionFile;
	private static FileConfiguration bossRegions;

	//Finds or generates custom YAML file
	public static void setup() {
		regionFile = new File(Bukkit.getServer().getPluginManager().getPlugin("MobBosses").getDataFolder(), "bossregions.yml");

		if (!regionFile.exists()) {
			try {
				regionFile.createNewFile();
			}catch (IOException e) {
				e.printStackTrace();
			}


		}
		bossRegions = YamlConfiguration.loadConfiguration(regionFile);

	}

	// Get instance of custom config file
	public static FileConfiguration get() {
		return bossRegions;
	}

	// Save custom config file
	public static void save() {
		try {
			bossRegions.save(regionFile);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Couldn't save file");
		}
	}

	// Reload custom config file, use if changes are made to the file directly
	public static void reload() {
		try {
			bossRegions = YamlConfiguration.loadConfiguration(regionFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
