package me.Ikeetjeop.WG.CMD;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;

import com.google.common.collect.Lists;

public class WGTcmd implements CommandExecutor,TabCompleter{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("rg")){
			if(args.length == 0){
				Bukkit.dispatchCommand(sender, "regions");
				sender.sendMessage(ChatColor.RED + "[WGT] Succsesfull loaded! V1.0");
				if(sender.hasPermission("WGT.Tab")){
					sender.sendMessage(ChatColor.RED + "[WGT] Do /rg [TabButton] for start!");
				}
			} else {
				String fullString = "";
				for(String s : args){
					fullString += (s + ' ');
				}

				Bukkit.dispatchCommand(sender, "regions " + fullString);
			}
		}
		return false;
	}
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		List<String> s1 = Arrays.asList("flag" , "select", "migrateuuid", "setpriority", "teleport", "save", "addowner", "removeowner", "list", "remove",
				"addmember", "redefine", "define", "claim", "setparent", "info", "migratedb" , "reload");
		List<String> s2 = Arrays.asList("passthrough", "build", "construct", "interact", "block-break", "block-place", "use", "damage-animals", "chest-access",
				"ride", "pvp", "sleep", "tnt", "vehicle-place", "vehicle-destroy", "lighter", "creeper-explosion", "enderdragon-block-damage", "ghast-fireball",
				"other-explosion", "fire-spread", "enderman-grief", "mob-damage", "mob-spawning", "deny-spawn", "entity-painting-destroy", "entity-item-frame-destroy",
				"lava-fire", "lightning", "water-flow", "lava-flow", "snow-fall", "snow-melt", "ice-form", "ice-melt", "mushroom-growth", "leaf-decay", "grass-growth",
				"mycelium-spread", "vine-growth", "soil-dry", "item-pickup", "item-drop", "exp-drops", "deny-message", "entry", "exit", "greeting", "greeting", "enderpearl",
				"invincible", "game-mode", "time-lock", "weather-lock", "heal-delay", "heal-amount", "heal-min-health", "heal-max-health", "feed-delay", "feed-amount",
				"feed-min-hunger", "feed-max-hunger", "teleport", "spawn", "blocked-cmds", "allowed-cmds", "pistons", "send-chat", "receive-chat", "potion-splash", "notify-enter",
				"notify-leave", "allow-shop", "buyable", "price");
		List<String> s3 = Arrays.asList("allow", "deny", "none");
		List<String> gamemode = Arrays.asList("survival", "creative", "adventure", "spectator", "none");
		List<String> location = Arrays.asList("here", "X.X,Y.Y,Z.Z,YAW.YAW,PITCH.PITCH", "0.0,0.0,0.0,0.0,0.0", "none");
		List<String> yes = Arrays.asList("yes", "no");
		List<String> cmds = Arrays.asList("/tp,/tpa");
		List<String> weather = Arrays.asList("downfall", "clear");
		List<EntityType> Mobs = Arrays.asList(EntityType.values());
		List<String> Flist = Lists.newArrayList();

		if(sender.hasPermission("WGT.Tab")){
			if(args.length == 1){
				for(String s : s1){
					if(s.toLowerCase().startsWith(args[0].toLowerCase())){
						Flist.add(s);
					}
				}
				return Flist;
			}
			if(args.length == 3){
				if(args[0].equalsIgnoreCase("flag")){
					for(String s : s2){
						if(s.toLowerCase().startsWith(args[2].toLowerCase())) Flist.add(s);
					}
				}
				return Flist;
			}
			if(args.length == 4){
				if(args[0].equalsIgnoreCase("flag")){
					if(!(args[2].equalsIgnoreCase("greeting") 
							|| args[2].equalsIgnoreCase("farewell") 
							|| args[2].equalsIgnoreCase("heal-amount")
							|| args[2].equalsIgnoreCase("spawn")
							|| args[2].equalsIgnoreCase("deny-spawn")
							|| args[2].equalsIgnoreCase("deny-message")
							|| args[2].equalsIgnoreCase("game-mode")
							|| args[2].equalsIgnoreCase("time-lock")
							|| args[2].equalsIgnoreCase("weather-lock")
							|| args[2].equalsIgnoreCase("heal-delay")
							|| args[2].equalsIgnoreCase("heal-amount")
							|| args[2].equalsIgnoreCase("heal-min-health")
							|| args[2].equalsIgnoreCase("heal-max-health")
							|| args[2].equalsIgnoreCase("feed-delay")
							|| args[2].equalsIgnoreCase("feed-amount")
							|| args[2].equalsIgnoreCase("feed-min-hunger")
							|| args[2].equalsIgnoreCase("feed-max-hunger")
							|| args[2].equalsIgnoreCase("teleport")
							|| args[2].equalsIgnoreCase("blocked-cmds")
							|| args[2].equalsIgnoreCase("allowed-cmds")
							|| args[2].equalsIgnoreCase("notify-enter")
							|| args[2].equalsIgnoreCase("notify-leave")
							|| args[2].equalsIgnoreCase("buyable")
							|| args[2].equalsIgnoreCase("price")
							)){
						for(String s : s3){
							if(s.toLowerCase().startsWith(args[3].toLowerCase())) Flist.add(s);
						}
					} else {
						if(args[2].equalsIgnoreCase("deny-message") || args[2].equalsIgnoreCase("farewell") || args[2].equalsIgnoreCase("greeting")){
							sender.sendMessage(ChatColor.RED + "" +ChatColor.BOLD + "Hey! " + ChatColor.GRAY + "This flag can't be tabbed, you need to enter a message.");
						} else if(args[2].equalsIgnoreCase("game-mode")){
							for(String s : gamemode){
								if(s.toLowerCase().startsWith(args[3].toLowerCase())) Flist.add(s);
							}
						} else if(args[2].equalsIgnoreCase("heal-amount") 
								|| args[2].equalsIgnoreCase("feed-delay")
								|| args[2].equalsIgnoreCase("feed-min-hunger")
								|| args[2].equalsIgnoreCase("feed-max-hunger")
								|| args[2].equalsIgnoreCase("feed-amount")
								|| args[2].equalsIgnoreCase("time-lock") 
								|| args[2].equalsIgnoreCase("heal-delay")
								|| args[2].equalsIgnoreCase("heal-amount")
								|| args[2].equalsIgnoreCase("heal-min-health")
								|| args[2].equalsIgnoreCase("heal-max-health")){
							sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Hey! " + ChatColor.GRAY + "This flag can't be tabbed, you need to enter a number.");
						}else if(args[2].equalsIgnoreCase("teleport") || args[2].equalsIgnoreCase("spawn")){
							for(String s : location){
								if(s.toLowerCase().startsWith(args[3].toLowerCase())){
									Flist.add(s);
								}
							}
						}else if(args[2].equalsIgnoreCase("notify-enter") || args[2].equalsIgnoreCase("notify-leave") || args[2].equalsIgnoreCase("buyable")){
							for(String s : yes){
								if(s.toLowerCase().startsWith(args[3].toLowerCase())){
									Flist.add(s);
								}
							}
						}else if(args[2].equalsIgnoreCase("blocked-cmds") || args[2].equalsIgnoreCase("allowed-cmds")){
							for(String s : cmds){
								if(s.toLowerCase().startsWith(args[3].toLowerCase())){
									Flist.add(s);
								}
							}
						}else if(args[2].equalsIgnoreCase("weather-lock")){
							for(String s : weather){
								if(s.toLowerCase().startsWith(args[3].toLowerCase())){
									Flist.add(s);
								}
							}
						}else if(args[2].equalsIgnoreCase("deny-spawn")){
							for(EntityType s : Mobs){
								if(s.toString().toLowerCase().startsWith(args[3].toLowerCase())){
									Flist.add(s.toString().toLowerCase());
								}
							}
						}
					}
				}	
				return Flist;
			}
		}

		return null;
	}
}