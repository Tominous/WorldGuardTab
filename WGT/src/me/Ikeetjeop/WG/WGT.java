package me.Ikeetjeop.WG;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.Ikeetjeop.WG.CMD.WGTcmd;
/*
Created by Ikeetjeop
 */

public class WGT extends JavaPlugin{
	public static WGT instance;
	public WGT(){
		instance = this;
	}

	public WorldGuardPlugin getWorldGuard() {
		Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");

		// WorldGuard may not be loaded
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null; // Maybe you want throw an exception instead
		}

		return (WorldGuardPlugin) plugin;
	}

	public static WGT getInstance() {
		return instance;
	}


	public void onEnable(){
		Bukkit.getLogger().severe("[WorldGuardTab] succses full enabled (Be sure you have installed worldguard!)");
		getCommand("rg").setExecutor(new WGTcmd());
		getCommand("rg").setTabCompleter(new WGTcmd());
	}
}