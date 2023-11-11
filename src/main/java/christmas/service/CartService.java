package christmas.service;

import christmas.domain.Cart;
import christmas.domain.Menu;
import christmas.view.InputView;

import java.util.HashMap;
import java.util.List;

import static christmas.service.MenuService.makeMenuMap;

public class CartService {

    public static Cart makeCart() {
        Cart cart = new Cart();
        while (true) {
            try {
                List<String> menuInput = InputView.readMenu();
                HashMap<String, Integer> menuMap = makeMenuMap(menuInput);
                addCart(menuMap,cart);
                return cart;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void addCart(HashMap<String, Integer> menuMap, Cart cart) {
        for (String menuName : menuMap.keySet()) {
            Menu menu = Menu.getMenu(menuName);
            cart.addMenuInCart(menu, menuMap.get(menuName));
        }
    }
}
