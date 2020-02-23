package me.xalgorhythms.mobbosses.files;

import me.xalgorhythms.mobbosses.bossregions.BossRegion;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegionMapStorage {

	public static Map<String, BossRegion> regionMap = new HashMap<>();
	public static Map<String, ArrayList> fightersList = new HashMap<>();

	public static Map<String, Location> loc1List = new HashMap<>();
	public static Map<String, Location> loc2List = new HashMap<>();

	public static void save() {

	}

	public static void load() {

	}

}
