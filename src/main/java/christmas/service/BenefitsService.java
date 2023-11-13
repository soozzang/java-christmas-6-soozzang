package christmas.service;


import christmas.domain.Cart;
import christmas.domain.Menu;

public class BenefitsService {

    public static long calculateDiscountInWeekday(Cart cart) {
        int desertCount = 0;
        for (Menu menu : cart.getCart().keySet()) {
            if (menu.getType().equals("디저트")) {
                desertCount += (cart.getCart().get(menu));
            }
        }
        return 2023L * desertCount;
    }

    public static long calculateDiscountInWeekend(Cart cart) {
        int mainCount = 0;
        for (Menu menu : cart.getCart().keySet()) {
            if (menu.getType().equals("메인")) {
                mainCount += (cart.getCart().get(menu));
            }
        }
        return 2023L * mainCount;
    }
}
