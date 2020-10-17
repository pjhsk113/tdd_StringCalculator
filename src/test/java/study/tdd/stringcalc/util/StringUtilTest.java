package study.tdd.stringcalc.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {
    @DisplayName("입력값 split 테스트")
    @Test
    public void split_Test() {
        assertThat(StringUtil.split("2 + 3 * 4 / 2")).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }
}