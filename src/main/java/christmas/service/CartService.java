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

                for (String menuName : menuMap.keySet()) {
                    Menu menu = Menu.getMenu(menuName);
                    cart.addMenuInCart(menu, menuMap.get(menuName));
                }
                return cart;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
