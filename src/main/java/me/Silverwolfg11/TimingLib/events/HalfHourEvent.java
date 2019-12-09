package me.Silverwolfg11.TimingLib.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class HalfHourEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public HalfHourEvent() {
        super(true);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() { return handlers; }
}
