package christmas.domain;

public class Restrictions {

    private final boolean isOverTenthousand;
    private final boolean NotOnlyDrink;
    private final boolean isOverTwenty;

    public Restrictions(Cart cart) {
        this.isOverTenthousand = checkIsOverTenthousand(cart);
        this.NotOnlyDrink = checkIsNotOnlyDrink(cart);
        this.isOverTwenty = checkIsOverTwenty(cart);
    }

    public boolean getIsOverTenthousand() {
        return isOverTenthousand;
    }

    public boolean getNotOnlyDrink() {
        return NotOnlyDrink;
    }

    public boolean getIsOverTwenty() {
        return isOverTwenty;
    }

    public boolean checkIsOverTenthousand(Cart cart) {
        return cart.calculatdTotalPrice() >= 10000L;
    }

    public boolean checkIsNotOnlyDrink(Cart cart) {
        boolean checkIsNotOnlyDrink = false;
        for (Menu menu : cart.getCart().keySet()) {
            if (!menu.getType().equals("음료")) {
                checkIsNotOnlyDrink = true;
                break;
            }
        }
        return checkIsNotOnlyDrink;
    }

    public boolean checkIsOverTwenty(Cart cart) {
        return cart.getCartSize() <= 20 && cart.getCartSize()>0;
    }

}
