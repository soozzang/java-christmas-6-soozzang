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

    public static void printChristmasDiscount(String christmasDdayDiscountForPrint) {
        if (christmasDdayDiscountForPrint.equals("0")) {
            System.out.println("없음");
            return;
        }
        System.out.println("크리스마스 디데이 할인: "+"-"+christmasDdayDiscountForPrint+"원");
    }

    public static void printDdayDiscount(String ddayDiscountForPrint) {
        if (ddayDiscountForPrint.equals("0")) {
            System.out.println("없음");
            return;
        }
        System.out.println("평일 할인: "+"-"+ddayDiscountForPrint+"원");
    }

    public static void printStarDiscount(String starDiscountForPrint) {
        if (starDiscountForPrint.equals("0")) {
            System.out.println("없음");
            return;
        }
        System.out.println("특별 할인: "+"-"+starDiscountForPrint+"원");
    }

    public static void printChampagneDiscount(String champagneForPrint) {
        if (champagneForPrint.equals("0")) {
            System.out.println("없음");
            return;
        }
        System.out.println("증정 이벤트: "+"-"+champagneForPrint+"원");
    }

    public static void printBenefitsList(Benefits benefits) {
        System.out.println("<혜택 내역>");
        printChristmasDiscount(benefits.getChristmasDdayDiscountForPrint());
        printDdayDiscount(benefits.getDayDiscountForPrint());
        printStarDiscount(benefits.getStarDisountForPrint());
        printChampagneDiscount(benefits.getChampagneForPrint());
        System.out.println(" ");
    }

    public static void printTotalBenefits(String totalBenefitsForPrint) {
        System.out.println("<총혜택 금액>");
        if (totalBenefitsForPrint.equals("0")) {
            System.out.println("없음");
            return;
        }
        System.out.println("-"+totalBenefitsForPrint+"원");
        System.out.println(" ");
    }

    public static void printFinalPrice(long predictedPrice) {
        String predictedPriceForPrint = String.format("%,d", predictedPrice);
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(predictedPriceForPrint+"원");
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
        printTotalBenefits(benefits.totalBenefitsForPrint());
        printFinalPrice(predictedPrice);
        printBadge(badge);
    }
}
