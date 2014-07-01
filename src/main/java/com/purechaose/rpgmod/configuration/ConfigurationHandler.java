package com.purechaose.rpgmod.configuration;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
	
	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);
		
		try {
			// load config
			config.load();
			
			// read properties
		} catch(Exception e) {
			// log exception
			
		} finally {
			// save config
			config.save();
		}
	}
}
