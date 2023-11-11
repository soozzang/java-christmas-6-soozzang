package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestrictionsTest {

    Cart cart = new Cart();
    Restrictions restrictions;

    @BeforeEach
    void makeCart() {
        cart.addMenuInCart(Menu.ZERO_COLA,1);
        restrictions = new Restrictions(cart);
    }

    @DisplayName("만원 이상인지 검증하는 메서드 테스트")
    @Test
    public void checkIsOverTenthousandTest() throws Exception {
        // when
        boolean isOverTenthousand = restrictions.checkIsOverTenthousand(cart);

        // then
        Assertions.assertThat(isOverTenthousand).isEqualTo(false);
    }

    @DisplayName("음료만 담긴 카트가 아닌지 검증하는 메서드 테스트")
    @Test
    public void checkIsNotOnlyDrinkTest() throws Exception {
        // when
        boolean isNotOnlyDrink = restrictions.getNotOnlyDrink();

        // then
        Assertions.assertThat(isNotOnlyDrink).isEqualTo(false);
    }

    @DisplayName("20개 넘는 수량을 담았는지 검증하는 메서드 테스트")
    @Test
    public void checkIsOverTwentyTest() throws Exception {
        // given
        Cart fullCart = new Cart();
        cart.addMenuInCart(Menu.BBQ_RIBS, 21);
        Restrictions fullCartRestrictions = new Restrictions(fullCart);

        // when
        boolean isOverTwenty = fullCartRestrictions.checkIsOverTwenty(fullCart);

        // then
        Assertions.assertThat(isOverTwenty).isEqualTo(false);
    }
}
