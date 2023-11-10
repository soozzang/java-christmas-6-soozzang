package christmas.service;

import christmas.domain.Date;
import christmas.domain.Day;
import christmas.view.InputView;

public class DateService {

    public static Date makeDate() {
        int dateInput = InputView.readDate();
        // 무슨 요일인지 검증
        Day day = Day.dayGenerator(dateInput);
        return new Date(dateInput,day);
    }
}
