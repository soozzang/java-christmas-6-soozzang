package christmas.domain;

import java.text.NumberFormat;
import java.util.HashMap;

public class Cart {

    private final HashMap<Menu,Integer> cart;

    public Cart() {
        this.cart = new HashMap<Menu,Integer>();
    }

    public void addMenuInCart(Menu menu, int numberOfEach) {
        cart.put(menu,numberOfEach);
    }

    public HashMap<Menu, Integer> getCart() {
        return cart;
    }

    public long calculatdTotalPrice() {
        long totalPrice = 0;
        for (Menu menu : cart.keySet()) {
            totalPrice += menu.getPrice() * cart.get(menu);
        }
        return totalPrice;
    }

    public String calculatedTotalPriceForPrint() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);
        return numberFormat.format(calculatdTotalPrice());
    }

    public int getCartSize() {
        return cart.size();
    }
}
