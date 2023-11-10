package christmas.domain;

public class Restrictions {

    private final boolean isOverTenthousand;
    private final boolean isOnlyDrink;
    private final boolean isOverTwenty;

    public Restrictions(Menu menu) {
        this.isOverTenthousand = checkIsOverTenthousand(menu);
        this.isOnlyDrink = checkIsOnlyDrink(menu);
        this.isOverTwenty = checkIsOverTwenty(menu);
    }

    public boolean checkIsOverTenthousand(Menu menu) {
        //
    }

    public boolean checkIsOnlyDrink(Menu menu) {
        //
    }

    public boolean checkIsOverTwenty(Menu menu) {
        //
    }

}
