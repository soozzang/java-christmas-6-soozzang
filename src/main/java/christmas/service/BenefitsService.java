package christmas.service;


import christmas.domain.Cart;
import christmas.domain.Menu;

public class BenefitsService {

    public static long calculateDiscountInWeekday(Cart cart) {
        for (Menu menu : cart.getCart().keySet()) {
            if (menu.getType().equals("디저트")) {
                return 2023L * (cart.getCart().get(menu));
            }
        }
        return 0;
    }

    public static long calculateDiscountInWeekend(Cart cart) {
        for (Menu menu : cart.getCart().keySet()) {
            if (menu.getType().equals("메인")) {
                return 2023L * (cart.getCart().get(menu));
            }
        }
        return 0;
    }
}
