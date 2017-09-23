package me.Ikeetjeop.WG;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.Ikeetjeop.WG.CMD.WGTcmd;
public class WGT extends JavaPlugin{
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage("[WorldGuardTab] Loaded!");
		getCommand("rg").setExecutor(new WGTcmd());
		getCommand("rg").setTabCompleter(new WGTcmd());

	}
}