package christmas.domain;

public class Date {

    private final boolean isChirstMasDdayDiscount;
    private final Day day;
    private final boolean isStarDate;

    public Date(int date, Day day) {
        this.isChirstMasDdayDiscount = checkIsChristMasDayDiscountDate(date);
        this.day = day;
        this.isStarDate = checkIsStarDate(date);
    }

    private boolean checkIsChristMasDayDiscountDate (int date) {
        //
    }

    private boolean checkIsStarDate(int date) {
        //
    }
}
