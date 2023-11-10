package christmas.domain;

import christmas.service.BenefitsService;

import java.text.NumberFormat;

public class Benefits {

    private final long christmasDdayDiscount;
    private final long dayDiscount;
    private final long starDisount;
    private final long champagne;

    public Benefits(Date date, Cart cart) {
        this.christmasDdayDiscount = calculateChristmasDdayDiscount(date);
        this.dayDiscount = calculateDayDiscount(date,cart);
        this.starDisount = calculateStarDisount(date,cart);
        this.champagne = calculateChampagne(cart.calculatdTotalPrice());
    }

    public String getChampagneForPrint() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);
        return numberFormat.format(champagne);
    }

    public String getChristmasDdayDiscountForPrint() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);
        return numberFormat.format(christmasDdayDiscount);
    }

    public String getDayDiscountForPrint() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);
        return numberFormat.format(dayDiscount);
    }

    public String getStarDisountForPrint() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);
        return numberFormat.format(starDisount);
    }

    private long calculateChristmasDdayDiscount(Date date) {
        // date 검증함수 후 christmasDdayDiscount 설정
        if (!date.getIsChristMasDayDiscount()) {
            return 0;
        }
        // 계산로직
        long christmansDdayDiscount = 1000;
        christmansDdayDiscount += 100L*(date.getDate() - 1 );
        return christmansDdayDiscount;
    }

    private long calculateDayDiscount(Date date, Cart cart) {
        // date 검증함수 후 dayDiscount 설정
        long dayDiscount = 0;
        if (date.getDay() == Day.WEEKDAY) {
            dayDiscount += BenefitsService.calculateDiscountInWeekday(cart);
        }
        if (date.getDay() == Day.WEEKEND) {
            dayDiscount += BenefitsService.calculateDiscountInWeekend(cart);
        }
        return dayDiscount;
    }

    private long calculateStarDisount(Date date, Cart cart) {
        // date 검증함수 후 starDiscount 설정
        if (!date.getIsStarDate()) {
            return 0;
        }
        // 계산 로직
        return 1000L;
    }

    private long calculateChampagne(long totalPrice) {
        // date 검증함수 후 Champagne 설정
        if (totalPrice >= 120000) {
            return 25000L;
        }
        return 0;
    }

    public long calculateTotalBenefits() {
        long totalBenefits = 0;
        totalBenefits += christmasDdayDiscount;
        totalBenefits += dayDiscount;
        totalBenefits += starDisount;
        totalBenefits += champagne;
        return totalBenefits;
    }

    public long calculateTotalDiscount() {
        return calculateTotalBenefits() - champagne;
    }

    public String totalBenefitsForPrint() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);
        return numberFormat.format(calculateTotalBenefits());
    }
}
