package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class DateTest {

    @Test
    public void checkIsStardDateTest() throws Exception {
        // given
        Date date = new Date(25, Day.WEEKDAY);

        // when
        boolean isStarDate = date.getIsStarDate();

        // then
        Assertions.assertThat(isStarDate).isEqualTo(true);
    }

    @Test
    public void checkIsChristMasDayDiscountDateTest() throws Exception {
        // given
        Date date = new Date(31, Day.WEEKDAY);

        // when
        boolean isChristMasDay = date.getIsChristMasDayDiscount();

        // then
        Assertions.assertThat(isChristMasDay).isEqualTo(false);
    }
}
