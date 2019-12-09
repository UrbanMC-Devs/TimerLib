package me.Silverwolfg11.TimingLib.events;

import me.Silverwolfg11.TimingLib.Day;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class NewDayEvent extends Event {
    private final static HandlerList handlers = new HandlerList();
    private Day day;

    public NewDayEvent() {
        super(true);

        day = Day.getDay();
    }


    public static HandlerList getHandlerList() { return handlers; }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Day getDay() {
        return day;
    }
}
