package christmas.domain;

public class Benefits {

    private final long christmasDdayDiscount;
    private final long dayDiscount;
    private final long starDisount;
    private final long champagne;

    public Benefits(Date date, Cart cart) {
        this.christmasDdayDiscount = calculateChristmasDdayDiscount(date);
        this.dayDiscount = calculateDayDiscount(date);
        this.starDisount = calculateStarDisount(date);
        this.champagne = calculateChampagne(cart.calculatdTotalPrice());
    }

    private long calculateChristmasDdayDiscount(Date date) {
        // date 검증함수 후 christmasDdayDiscount 설정
    }

    private long calculateDayDiscount(Date date) {
        // date 검증함수 후 dayDiscount 설정
    }

    private long calculateStarDisount(Date date) {
        // date 검증함수 후 starDiscount 설정
    }

    private long calculateChampagne(long totalPrice) {
        // date 검증함수 후 Champagne 설정
    }

    public long calculateTotalBenefits() {
        return
    }
}
