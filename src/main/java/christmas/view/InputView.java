package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputView {
    public static int readDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        while (true) {
            try {
                int date = validateDateIsInt(Console.readLine());
                dateValidations(date);
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void dateValidations(int date) {
        validateDateIsOutOfRange(date);
    }

    public static int validateDateIsInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateDateIsOutOfRange(int date) {
        if (!(date >= 1 && date <= 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static List<String> readMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return stringParser(Console.readLine());
    }

    public static List<String> stringParser(String menuInput) {
        String[] parsedMenuStr = menuInput.split(",");
        return new ArrayList<>(Arrays.asList(parsedMenuStr));
    }

    public static void validateCommaAfterComma(String menuInput) {

    }

    public static void validateIsContainBlank(String menuInput) {

    }

    public static void validateLastCharIsComma(String menuInput) {

    }

    public static void validateIsNotInMenu(String menuName) {
        boolean flag = false;
        for (Menu menu : Menu.values()) {
            if (menu.getKorName().equals(menuName)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateDuplicateMenu(List<String> nameList) {
        HashSet<String> menuSet = new HashSet<>(nameList);
        if (menuSet.size() != nameList.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
