package me.Silverwolfg11.TimingLib.events;

import me.Silverwolfg11.TimingLib.TimerLibPlugin;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class NewHourEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    public NewHourEvent() {
        super(true);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public int getHour() {
        return TimerLibPlugin.getHour();
    }

}
