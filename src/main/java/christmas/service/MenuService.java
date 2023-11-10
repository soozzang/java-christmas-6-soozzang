package christmas.service;

import christmas.domain.Menu;
import christmas.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuService {

    // 입력에서 List<String>으로 받은 걸 Menu 맵으로 바꿈
    // 콤마 기준 잘라서 문자 넣고 숫자 넣어서 완성
    public static HashMap<String, Integer> makeMenuMap(List<String> menuInput) {
        HashMap<String, Integer> menuMap = new HashMap<>();
        List<String> menuNameList = menuNameParser(menuInput);
        List<Integer> menuCountList = menuCountParser(menuInput);

        for (int i = 0; i < menuNameList.size(); i++) {
            menuMap.put(menuNameList.get(i), menuCountList.get(i));
        }
        return menuMap;
    }

    public static List<String> menuNameParser(List<String> menuInput) {
        List<String> menuNameList = new ArrayList<>();
        for (String eachInput : menuInput) {
            int idxOfHyphen = eachInput.indexOf("-");
            String menuName = eachInput.substring(0,idxOfHyphen);
            InputView.validateIsNotInMenu(menuName);
            menuNameList.add(menuName);
        }
        InputView.validateDuplicateMenu(menuNameList);
        return menuNameList;
    }

    public static List<Integer> menuCountParser(List<String> menuInput) {
        List<Integer> menuCountList = new ArrayList<>();
        for (String eachInput : menuInput) {
            int eachMenuCount = validateMenuCountIsInt(eachInput);
            validateMenuCountIsOutOfRange(eachMenuCount);
            menuCountList.add(eachMenuCount);
        }
        return menuCountList;
    }

    public static int validateMenuCountIsInt(String eachInput) {
        try {
            int idxOfHyphen = eachInput.indexOf("-");
            return Integer.parseInt(eachInput.substring(idxOfHyphen + 1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateMenuCountIsOutOfRange(int eachMenuCount) {
        if (eachMenuCount < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
