package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {

    @DisplayName("해당 조건에 맞는 메뉴를 제시하는지 확인")
    @Test
    public void getMenuTest() throws Exception {
        // given
        String korName = "양송이 수프";

        // when
        Menu menu = Menu.getMenu(korName);

        // then
        Assertions.assertThat(menu.getKorName()).isEqualTo("양송이 수프");
    }
}
