package christmas.domain;

public class Restrictions {

    private final boolean isOverTenthousand;
    private final boolean isOnlyDrink;
    private final boolean isOverTwenty;

    public Restrictions(Cart cart) {
        this.isOverTenthousand = checkIsOverTenthousand(cart);
        this.isOnlyDrink = checkIsOnlyDrink(cart);
        this.isOverTwenty = checkIsOverTwenty(cart);
    }

    public boolean checkIsOverTenthousand(Cart cart) {
        //
    }

    public boolean checkIsOnlyDrink(Cart cart) {
        //
    }

    public boolean checkIsOverTwenty(Cart cart) {
        //
    }

}
