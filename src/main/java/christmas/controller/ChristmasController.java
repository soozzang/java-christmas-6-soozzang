package christmas.controller;

import christmas.domain.*;
import christmas.service.CartService;
import christmas.service.DateService;
import christmas.service.RestrictionsService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;
import java.util.List;

import static christmas.service.MenuService.*;

public class ChristmasController {
    public void start() {
        Date date = DateService.makeDate();
        Cart cart = CartService.makeCart();
        Customer customer = new Customer(cart.calculatdTotalPrice());
        Restrictions restrictions = new Restrictions(cart);

        if (RestrictionsService.checkIsAbleToOrder(restrictions)){
            if (!RestrictionsService.checkIsAbleToApplyEvent(restrictions)) {
                startIfIsUnableToGetBenefits(customer);
                return;
            }
            startIfIsAbleToOrder(cart, date, customer);
            return;
        }
        System.out.println("구매 불가");
    }

    public void startIfIsAbleToOrder(Cart cart, Date date, Customer customer) {
        OutputView.printAboutMenu(cart);
        Benefits benefits = new Benefits(date,cart);
        customer.setCustomerBadge(benefits.calculateTotalBenefits());
        long predictedPrice = customer.getPaidMoneyBeforeDiscount() - benefits.calculateTotalDiscount();
        OutputView.printAfterChampagne(benefits,predictedPrice,customer.getBadge());
    }

    public void startIfIsUnableToGetBenefits(Customer customer) {
        OutputView.printNoBenefits(customer.getPaidMoneyBeforeDiscount());
    }



}
