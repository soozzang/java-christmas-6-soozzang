package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CustomerTest {

    private Date date;
    private Cart cart;

    @BeforeEach
    void makeDateAndCart() {
        date = new Date(1, Day.WEEKDAY);
        cart = new Cart();
        cart.addMenuInCart(Menu.BBQ_RIBS, 10);
    }

    @DisplayName("조건에 맞는 배지를 수여하는지 검증하는 테스트")
    @Test
    public void setCustomerBadgeTest() throws Exception {
        // given
        Customer customer = new Customer(150000L);
        Benefits benefits = new Benefits(date,cart);

        // when
        customer.setCustomerBadge(benefits.getTotalBenefits());

        // then
        Assertions.assertThat(customer.getBadge()).isEqualTo(Badge.산타);
    }
}
