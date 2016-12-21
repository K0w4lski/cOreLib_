package com.kowalski_.moreapi.config;

import java.io.File;

import com.kowalski_.moreapi.mOreApi;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static Configuration config;
	
	public static boolean ThermalFoundationOreSpawn;
	public static boolean ImmersiveEngineeringOreSpawn;
	
	public static void init(File file)
	{
		config = new Configuration(file);
		syncConfig();
	}
	
	public static void syncConfig()
	{
		String cat;
		
		cat = "Mod ore spawn";
		config.addCustomCategoryComment(cat, "Mod ore spawn");
		ThermalFoundationOreSpawn = config.getBoolean("ThermalFoundation", cat, false, "False - No Thermal foundation Ore Spawn");
		ImmersiveEngineeringOreSpawn = config.getBoolean("ImmersiveEngineering", cat, false, "False - No Immersive Engineering Ore Spawn");
		config.save();
	}
}
