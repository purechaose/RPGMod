package com.purechaose.rpgmod;

import com.purechaose.rpgmod.configuration.ConfigurationHandler;
import com.purechaose.rpgmod.lib.Reference;
import com.purechaose.rpgmod.proxy.IProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * @author PureChaose
 *
 */

@Mod(
		modid = Reference.MOD_ID,
		name = Reference.MOD_NAME,
		version = Reference.VERSION)

public class RPG {

	@Mod.Instance(Reference.MOD_ID)
	public static RPG instance;
	
	@SidedProxy(
			clientSide = Reference.CLIENT_PROXY_CLASS, 
			serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}