package me.Silverwolfg11.TimingLib;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimerLibCmd implements CommandExecutor {

    private TimerLibPlugin plugin;

    public TimerLibCmd(TimerLibPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!sender.hasPermission("timerlib.command")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /timerlib [last/time/reset]");
            return true;
        }

        if (args[0].equalsIgnoreCase("last")) {
            sender.sendMessage(ChatColor.GREEN + "Events last executed " + ((System.currentTimeMillis() / 1000L) - plugin.getLastRunTime()) + " seconds ago!");
        }

        else if (args[0].equalsIgnoreCase("reset")) {
            Bukkit.getScheduler().cancelTasks(plugin);
            new FiveMinRunnable(plugin);
            sender.sendMessage(ChatColor.GREEN + "Reset TimerLib task!");
        }

        else if (args[0].equalsIgnoreCase("time")) {
            sender.sendMessage(ChatColor.GOLD + "Hour: " + TimerLibPlugin.getHour() + ". Minute: " + TimerLibPlugin.getMinute());
        }

        return true;
    }
}
