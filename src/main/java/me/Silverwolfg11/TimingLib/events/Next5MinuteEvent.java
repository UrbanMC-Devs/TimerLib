package me.Silverwolfg11.TimingLib.events;

import me.Silverwolfg11.TimingLib.TimerLibPlugin;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class Next5MinuteEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public Next5MinuteEvent() {
        super(true);
    }

    public int getMinute() {
        return TimerLibPlugin.getMinute();
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() { return handlers; }
}
