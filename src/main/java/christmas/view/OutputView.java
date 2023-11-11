package christmas.view;

import christmas.domain.Badge;
import christmas.domain.Benefits;
import christmas.domain.Cart;
import christmas.domain.Menu;

public class OutputView {

    public static void printMenuList(Cart cart) {
        System.out.println("\n<주문 메뉴>");
        for (Menu menu : cart.getCart().keySet()) {
            System.out.print(menu.getKorName()+" "+cart.getCart().get(menu)+"개\n");
        }
        System.out.println(" ");
    }

    public static void printTotalPriceBefoeDiscount(Cart cart) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(cart.calculatedTotalPriceForPrint()+"원\n");
    }

    public static void printChampagne() {
        System.out.println("<증정 메뉴>");
        System.out.println("샴페인 1개");
        System.out.println(" ");
    }

    public static void printChristmasDiscount(long christmasDdayDiscount) {
        if (christmasDdayDiscount == 0) {
            System.out.println("없음");
            return;
        }
        System.out.println("크리스마스 디데이 할인: "+"-"+String.format("%,d", christmasDdayDiscount)+"원");
    }

    public static void printDdayDiscount(long ddayDiscount) {
        if (ddayDiscount == 0) {
            System.out.println("없음");
            return;
        }
        System.out.println("평일 할인: "+"-"+String.format("%,d", ddayDiscount)+"원");
    }

    public static void printStarDiscount(long starDiscount) {
        if (starDiscount == 0) {
            System.out.println("없음");
            return;
        }
        System.out.println("특별 할인: "+"-"+String.format("%,d", starDiscount)+"원");
    }

    public static void printChampagneDiscount(long champagne) {
        if (champagne == 0) {
            System.out.println("없음");
            return;
        }
        System.out.println("증정 이벤트: "+"-"+String.format("%,d", champagne)+"원");
    }

    public static void printBenefitsList(Benefits benefits) {
        System.out.println("<혜택 내역>");
        printChristmasDiscount(benefits.getChristmasDdayDiscount());
        printDdayDiscount(benefits.getDayDiscount());
        printStarDiscount(benefits.getStarDisount());
        printChampagneDiscount(benefits.getChampagne());
        System.out.println(" ");
    }

    public static void printTotalBenefits(long totalBenefits) {
        System.out.println("<총혜택 금액>");
        if (totalBenefits == 0) {
            System.out.println("없음");
            return;
        }
        System.out.println("-"+String.format("%,d", totalBenefits)+"원");
        System.out.println(" ");
    }

    public static void printFinalPrice(long predictedPrice) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d", predictedPrice)+"원");
        System.out.println(" ");
    }

    public static void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

    public static void printNoBenefits(long totalPrice) {
        System.out.println("<증정 메뉴>\n없음\n");
        System.out.println("<혜택 내역>\n없음\n");
        System.out.println("<총혜택 금액>\n0원\n");
        System.out.println("<할인 후 예상 결제 금액>\n"+totalPrice+"원\n");
        System.out.println("<12월 이벤트 배지>\n없음");
    }

    public static void printAboutMenu(Cart cart) {
        printMenuList(cart);
        printTotalPriceBefoeDiscount(cart);
    }

    public static void printAfterChampagne(Benefits benefits, long predictedPrice, Badge badge) {
        printChampagne();
        printBenefitsList(benefits);
        printTotalBenefits(benefits.getTotalBenefits());
        printFinalPrice(predictedPrice);
        printBadge(badge);
    }
}
