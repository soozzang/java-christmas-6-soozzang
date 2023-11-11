package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTest {

    @DisplayName("카트안에 메뉴가 잘 담기는지 테스트")
    @Test
    public void addMenuInCartTest() throws Exception {
        // given
        Cart cart = new Cart();

        // when
        cart.addMenuInCart(Menu.ZERO_COLA,1);
        cart.addMenuInCart(Menu.BBQ_RIBS,1);

        // then
        Assertions.assertThat(cart.getCartSize()).isEqualTo(2);
    }

    @DisplayName("총 구매가격이 잘 계산되는지 테스트")
    @Test
    public void calculatdTotalPriceTest() throws Exception {
        // given
        Cart cart = new Cart();

        // when
        cart.addMenuInCart(Menu.ZERO_COLA,1);
        cart.addMenuInCart(Menu.BBQ_RIBS,1);

        // then
        Assertions.assertThat(cart.calculatdTotalPrice()).isEqualTo(57000);
    }
}
