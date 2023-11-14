package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DayTest {

    @Test
    public void dayGeneratorTest() throws Exception {
        // given
        int date = 1;  // 주말

        // when
        Day today = Day.dayGenerator(date);

        // then
        Assertions.assertThat(today).isEqualTo(Day.WEEKEND);
    }
}
