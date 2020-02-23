package me.xalgorhythms.mobbosses.Files;

import me.xalgorhythms.mobbosses.BossRegions.BossRegion;
import org.bukkit.Location;

import java.io.*;
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
