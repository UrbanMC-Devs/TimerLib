package me.Silverwolfg11.TimingLib;

import java.util.Calendar;

public enum Day {

    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7),
    SUNDAY(1);

    private int dayNumb;

    Day(int dayNumb) {
        this.dayNumb = dayNumb;
    }

    public int toInt() { return dayNumb; }

    public static Day fromInt(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1: return SUNDAY;
            case 2: return MONDAY;
            case 3: return TUESDAY;
            case 4: return WEDNESDAY;
            case 5: return THURSDAY;
            case 6: return FRIDAY;
            case 7: return SATURDAY;
            default: return null;
        }
    }

    public static Day getDay() {
        return fromInt(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
    }

}
