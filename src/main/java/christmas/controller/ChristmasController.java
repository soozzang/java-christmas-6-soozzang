package christmas.controller;

import christmas.domain.*;
import christmas.view.InputView;

import java.util.HashMap;
import java.util.List;

import static christmas.service.MenuService.*;

public class ChristmasController {
    Cart cart = new Cart();
    Restrictions restrictions = new Restrictions(cart);
    public void start() {
        // 날짜 입력
        int dateInput = InputView.readDate();
        // 무슨 요일인지 검증
        Day day = Day.daygenerator(dateInput);
        Date date = new Date(dateInput,day);

        // 주문 메뉴 및 개수
        List<String> menuInput = InputView.readMenu();

        // 카트에 넣기
        HashMap<String, Integer> menuMap = makeMenuMap(menuInput);
        for (String menuName : menuMap.keySet()) {
            Menu menu = Menu.getMenu(menuName);
            cart.addMenuInCart(menu, menuMap.get(menuName));
        }

        // 제한 사항 검토
        restrictions.checkIsOverTenthousand(cart);
        // 추가 로직 (검토 사항에 따라 제한)

        // 고객 도메인 채우기
        Customer customer = new Customer(cart.calculatdTotalPrice());

        // 주문 메뉴 출력
        // 할인 전 총주문 금액 출력

        // 혜택 도메인 채우기
        Benefits benefits = new Benefits(date,cart);

        // 샴페인 증정하는 지 검증 후 출력
        // 메서드(benefits) boolean 뱉음

        // 혜택 내역을 출력한다.

        // 총 혜택 금액 출력
        long totalBenefits = benefits.calculateTotalBenefits();

        // 할인 후 예상 결제 금액 출력
        long predictedPrice = customer.getPaidMoneyBeforeDiscount() - benefits.calculateTotalBenefits();

        // 배지 선택 후 출력
        customer.setCustomerBadge(totalBenefits);
        customer.getBadge();
    }
}
