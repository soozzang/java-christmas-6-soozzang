package christmas.service;

import christmas.domain.Menu;

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
            menuNameList.add(eachInput.substring(0,idxOfHyphen));
        }
        return menuNameList;
    }

    public static List<Integer> menuCountParser(List<String> menuInput) {
        List<Integer> menuCountList = new ArrayList<>();
        for (String eachInput : menuInput) {
            int idxOfHyphen = eachInput.indexOf("-");
            int eachMenuCount = Integer.parseInt(eachInput.substring(idxOfHyphen + 1));
            menuCountList.add(eachMenuCount);
        }
        return menuCountList;
    }
}
