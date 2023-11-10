package christmas.domain;

import java.util.HashMap;

public class Cart {

    private final HashMap<Menu,Integer> cart;

    public Cart() {
        this.cart = new HashMap<Menu,Integer>();
    }

    public void addMenuInCart(Menu menu, int numberOfEach) {
        cart.put(menu,numberOfEach);
    }

    public static long calculatdTotalPrice() {

    }
}
