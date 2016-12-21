package com.kowalski_.moreapi;

import java.io.File;

import com.kowalski_.moreapi.config.ConfigHandler;
import com.kowalski_.moreapi.ores.OreLoader;
import com.kowalski_.moreapi.proxies.CommonProxy;
import com.kowalski_.moreapi.util.SupportedModsList;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = mOreApi.MODID, version = mOreApi.VERSION)
public class mOreApi
{
	
	@SidedProxy(serverSide = "kowalski_.moreapi.proxy.CommonProxy", clientSide = "kowalski_.moreapi.proxy.ClientProxy")
	public static CommonProxy proxy;
	
    public static final String MODID = "moreapi";
    public static final String VERSION = "0.1 Alpha";
    
    public static final String MODLIST_FILENAME = "mOreApi_Modlist.txt";
    public static final String BASE_CONFIG_FILENAME = "mOreApi_Config.txt";
    public static final String DEFAULT_BASE_CONFIG_FILENAME = "mOreApi_DafaultConfig.txt";
    
    public static File getConfigDir() {return configDir;}
    
    //Private:
    
    private static File configDir;
    private static String[] SupportedMods = {
    		"ThermalFoundation",
    		"immersiveengineering"
    };
    		
    
    @Instance("moreapi")
    public static mOreApi instance;
    
    //Initialization:
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	OreLoader.preInit();
    	
    	configDir = new File(event.getSuggestedConfigurationFile() + "/" + MODID);
    	configDir.mkdirs();
    	ConfigHandler.init(new File(configDir.getPath(), MODID + ".cfg"));
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	CheckAvailableMods();
    }
    
    //Checking which modifications are loaded:
    
    public void CheckAvailableMods()
    {	
    	for(int x=0; x<SupportedMods.length; x++)
    	{
    		System.out.println("mOreApi checked if mod is loaded: " + SupportedMods[x]);
    		if(Loader.isModLoaded(SupportedMods[x]))
    		{
    			System.out.println("mOreApi detected that mod: " + SupportedMods[x] + " is loaded");
    			switch(x)
    			{
    			case 0:
    				SupportedModsList.isThermalFoundationLoaded = true;
    				break;
    			case 1:
    				SupportedModsList.isImmersiveEngineeringLoaded = true;
    				break;
    			}
    		}
    	}
    }
}
