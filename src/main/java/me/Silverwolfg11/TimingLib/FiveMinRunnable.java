package me.Silverwolfg11.TimingLib;

import me.Silverwolfg11.TimingLib.events.HalfHourEvent;
import me.Silverwolfg11.TimingLib.events.NewDayEvent;
import me.Silverwolfg11.TimingLib.events.NewHourEvent;
import me.Silverwolfg11.TimingLib.events.Next5MinuteEvent;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalDateTime;

public class FiveMinRunnable extends BukkitRunnable {

    private TimerLibPlugin plugin;
    private boolean canRun = true;

    FiveMinRunnable(TimerLibPlugin plugin) {
        this.plugin = plugin;

        LocalDateTime dateTime = LocalDateTime.now();

        int min = dateTime.getMinute();

        int oneMin = (min % 10);

        int timeRem = (oneMin < 5) ? 5 - oneMin : 10 - oneMin;

        int secondsRemaining = (60 - dateTime.getSecond()) + (60 * --timeRem);

        plugin.setMinute(min);

        runTaskTimerAsynchronously(plugin, secondsRemaining * 20, 5 * 60 * 20);
    }

    @Override
    public void run() {
        // Safety check so there's no way two tasks can run at once
        if (!canRun) {
            release();
            return;
        }

        LocalDateTime dateTime = LocalDateTime.now();

        int minute = dateTime.getMinute();

        int trimmedMin = minute % 5;

        plugin.setLastRunTime();

        // Account for lag
        minute += trimmedMin > 3 ? (5 - trimmedMin) : -trimmedMin;

        plugin.incrementMinute();

        if (minute == 0) {
            plugin.incrementHour();
            NewHourEvent event = new NewHourEvent();
            Bukkit.getPluginManager().callEvent(event);

            if (TimerLibPlugin.getHour() == 0) {
                NewDayEvent dayEvent = new NewDayEvent();
                Bukkit.getPluginManager().callEvent(dayEvent);
            }
        }

        if (minute == 0 || minute == 30) {
            HalfHourEvent event = new HalfHourEvent();
            Bukkit.getPluginManager().callEvent(event);
        }

        Next5MinuteEvent incrementEvent = new Next5MinuteEvent();
        Bukkit.getPluginManager().callEvent(incrementEvent);

        if (trimmedMin > 1) {
            // Reschedule at the end so the event can still run
            canRun = false;
            new FiveMinRunnable(plugin);
            release();
        }
    }

    private void release() {
        plugin = null;
        cancel();
    }
}
