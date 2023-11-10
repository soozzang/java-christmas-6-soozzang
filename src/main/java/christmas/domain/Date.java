package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Date {

    private final boolean isChirstMasDdayDiscount;
    private final Day day;
    private final boolean isStarDate;
    private final int date;

    public Date(int date, Day day) {
        this.date = date;
        this.isChirstMasDdayDiscount = checkIsChristMasDayDiscountDate(date);
        this.day = day;
        this.isStarDate = checkIsStarDate(date);
    }

    public Day getDay() {
        return day;
    }

    public int getDate() {
        return date;
    }

    public boolean getIsChristMasDayDiscount() {
        return isChirstMasDdayDiscount;
    }

    public boolean getIsStarDate() {
        return isStarDate;
    }

    private boolean checkIsChristMasDayDiscountDate (int date) {
        if (date >= 1 && date <= 25) {
            return true;
        }
        return false;
    }

    private boolean checkIsStarDate(int date) {
        LocalDate localdate = LocalDate.of(2023, Month.DECEMBER, date);
        DayOfWeek getDay = localdate.getDayOfWeek();
        if (getDay == DayOfWeek.SUNDAY || date == 25) {
            return true;
        }
        return false;
    }
}
