package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public enum Day {
    WEEKDAY,WEEKEND;

    public static Day dayGenerator(int dateInput) {
        LocalDate localdate = LocalDate.of(2023, Month.DECEMBER, dateInput);
        DayOfWeek dayOfWeek = localdate.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            return WEEKEND;
        }
        return WEEKDAY;
    }
}
