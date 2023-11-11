package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BenefitsTest {

    private Date date;
    private final Cart cart = new Cart();

    @DisplayName("크리스마스 디데이할인 기간일 때, 할인 적용이 잘되는지 확인")
    @Test
    public void calculateChristmasDdayDiscountTest() throws Exception {
        // given
        date = new Date(24, Day.WEEKDAY);
        cart.addMenuInCart(Menu.SEAFOOD_PASTA,1);
        Benefits benefits = new Benefits(date, cart);

        // when
        long christmasDiscount = benefits.calculateChristmasDdayDiscount(date);

        // then
        Assertions.assertThat(christmasDiscount).isEqualTo(3300L);
    }

    @DisplayName("주말/평일 할인이 잘 적용되는지 테스트")
    @Test
    public void calculateDayDiscountTest() throws Exception {
        // given
        date = new Date(23, Day.WEEKEND);
        cart.addMenuInCart(Menu.SEAFOOD_PASTA,1);
        Benefits benefits = new Benefits(date, cart);

        // when
        long dayDiscount = benefits.calculateDayDiscount(date,cart);

        // then
        Assertions.assertThat(dayDiscount).isEqualTo(2023L);
    }

    @DisplayName("특별할인이 잘 적용되는지 테스트")
    @Test
    public void calculateStarDisountTest() throws Exception {
        // given
        date = new Date(24, Day.WEEKDAY);
        cart.addMenuInCart(Menu.SEAFOOD_PASTA,1);
        Benefits benefits = new Benefits(date, cart);

        // when
        long starDiscount = benefits.calculateStarDisount(date,cart);

        // then
        Assertions.assertThat(starDiscount).isEqualTo(1000L);
    }

    @DisplayName("샴페인 증정 이벤트가 잘 적용되는지 테스트")
    @Test
    public void calculateChampagneTest() throws Exception {
        // given
        date = new Date(24, Day.WEEKDAY);
        cart.addMenuInCart(Menu.SEAFOOD_PASTA,10);
        Benefits benefits = new Benefits(date, cart);
        long totalPrice = 350000L;

        // when
        long champagne = benefits.calculateChampagne(totalPrice);

        // then
        Assertions.assertThat(champagne).isEqualTo(25000L);
    }

    @DisplayName("총 혜택 금액이 잘 나오는지 테스트")
    @Test
    public void calculateTotalBenefitsTest() throws Exception {
        // given
        date = new Date(24, Day.WEEKDAY);
        cart.addMenuInCart(Menu.SEAFOOD_PASTA,1);
        Benefits benefits = new Benefits(date, cart);

        // when
        long totalBenefits = benefits.calculateTotalBenefits();

        // then
        Assertions.assertThat(totalBenefits).isEqualTo(4300L);
    }
}
