package christmas;

import christmas.service.MenuService;
import christmas.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ExceptionTest {

    @Test
    public void validateDateIsIntTest() throws Exception {
        // given
        String input = "a";

        // when,then
        Assertions.assertThatThrownBy(() -> InputView.validateDateIsInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void validateDateIsOutOfRange() throws Exception {
        // given
        int date = 35;

        // when,then
        Assertions.assertThatThrownBy(() -> InputView.validateDateIsOutOfRange(date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateLastCharIsCommaTest() throws Exception {
        // given
        String inputMenu = "레드와인-1,";

        // when,then
        Assertions.assertThatThrownBy(() -> InputView.validateLastCharIsComma(inputMenu))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void validateMenuCountIsIntTest() throws Exception {
        // given
        String eachInput = "레드와인-a";

        // when,then
        Assertions.assertThatThrownBy(() -> MenuService.validateMenuCountIsInt(eachInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateMenuCountIsOutOfRangeTest() throws Exception {
        // given
        int eachMenuCount = 0;

        // when,then
        Assertions.assertThatThrownBy(() -> MenuService.validateMenuCountIsOutOfRange(eachMenuCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateMenuBetweenDashTest() throws Exception {
        // given
        String eachInput = "레드와인1";

        // when,then
        Assertions.assertThatThrownBy(() -> MenuService.validateMenuBetweenDash(eachInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateDuplicateMenuTest() throws Exception {
        // given
        List<String> nameList = List.of("레드와인","제로콜라","제로콜라");

        // when,then
        Assertions.assertThatThrownBy(() -> MenuService.validateDuplicateMenu(nameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateIsNotInMenuTest() throws Exception {
        // given
        String menuName = "화이트와인";

        // when,then
        Assertions.assertThatThrownBy(() -> MenuService.validateIsNotInMenu(menuName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
