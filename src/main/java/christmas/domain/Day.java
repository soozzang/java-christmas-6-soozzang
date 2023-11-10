package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public enum Day {
    WEEKDAY,WEEKEND;

    public static Day daygenerator(int dateInput) {
        int year = 2023;
        Month month = Month.DECEMBER;
        DayOfWeek dayOfWeek = LocalDate.of(dateInput,month,year).getDayOfWeek();
        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            return WEEKEND;
        }
        return WEEKDAY;
    }
}
