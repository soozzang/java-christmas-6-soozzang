package christmas.domain;

import christmas.service.BenefitsService;

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

    public long getChampagne() {
        return champagne;
    }

    public long getChristmasDdayDiscount() {
        return christmasDdayDiscount;
    }

    public long getDayDiscount() {
        return dayDiscount;
    }

    public long getStarDisount() {
        return starDisount;
    }

    public long calculateChristmasDdayDiscount(Date date) {
        if (!date.getIsChristMasDayDiscount()) {
            return 0;
        }
        long christmansDdayDiscount = 1000;
        christmansDdayDiscount += 100L*(date.getDate() - 1 );
        return christmansDdayDiscount;
    }

    public long calculateDayDiscount(Date date, Cart cart) {
        long dayDiscount = 0;
        if (date.getDay() == Day.WEEKDAY) {
            dayDiscount += BenefitsService.calculateDiscountInWeekday(cart);
        }
        if (date.getDay() == Day.WEEKEND) {
            dayDiscount += BenefitsService.calculateDiscountInWeekend(cart);
        }
        return dayDiscount;
    }

    public long calculateStarDisount(Date date, Cart cart) {
        // date 검증함수 후 starDiscount 설정
        if (!date.getIsStarDate()) {
            return 0;
        }
        // 계산 로직
        return 1000L;
    }

    public long calculateChampagne(long totalPrice) {
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

    public long getTotalBenefits() {
        return calculateTotalBenefits();
    }
}
