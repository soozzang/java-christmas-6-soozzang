package christmas.domain;

public class Benefits {

    private final long christmasDdayDiscount;
    private final long dayDiscount;
    private final long starDisount;
    private final long champagne;

    Benefits() {
        this.christmasDdayDiscount = 0;
        this.dayDiscount = 0;
        this.starDisount = 0;
        this.champagne = 0;
    }

    public void setChristmasDdayDiscount(Date date) {
        // date 검증함수 후 christmasDdayDiscount 설정
    }

    public void setDayDiscount(Date date) {
        // date 검증함수 후 dayDiscount 설정
    }

    public void setStarDisount(Date date) {
        // date 검증함수 후 starDiscount 설정
    }

    public void setChampagne(Date date) {
        // date 검증함수 후 Champagne 설정
    }
}
