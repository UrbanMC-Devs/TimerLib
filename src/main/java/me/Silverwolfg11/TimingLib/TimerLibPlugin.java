package me.Silverwolfg11.TimingLib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;

public class TimerLibPlugin extends JavaPlugin {

    private static int hour;
    private static int minute;
    private AtomicLong lastRunTime = new AtomicLong();

    public void onEnable() {

        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = LocalDateTime.now().getMinute();
        minute = (minute / 5) * 5;

        new FiveMinRunnable(this);

        Bukkit.getLogger().info("[TimerLib] Time set! Hour: " + hour + ". Minute: " + minute);

        getCommand("timerlib").setExecutor(new TimerLibCmd(this));
    }

    public static int getHour() {
        return hour;
    }

    // Only updates every 5 minutes
    public static int getMinute() {
        return minute;
    }

    void incrementHour() {
        hour += (hour == 23 ? -23 : 1);
    }

    void incrementMinute() {
        minute += (minute == 55) ? -55 : 5;
    }

    void setMinute(int minute) {
        TimerLibPlugin.minute = 5 * (minute / 5);
    }

    void setLastRunTime() {
        lastRunTime.set(System.currentTimeMillis() / 1000L);
    }

    long getLastRunTime() {
        return lastRunTime.get();
    }
}
