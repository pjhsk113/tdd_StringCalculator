package study.tdd.stringcalc.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @DisplayName("입력 값이 공백일 경우 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    public void 입력값은_공백이_아니어야한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculateResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1000 + 20000 : 21000",
            "200 - 100 : 100",
            "20 / 5 : 4",
            "30 * 3 : 90",
            "2 + 6 * 2 / 8 : 2",
            "2 + 3 * 4 / 2 : 10",
            "20 / 3 * 4 - 2 : 22", }, delimiter = ':')
    public void 사칙연산_테스트(final String input, final int result) {
        assertThat(StringCalculator.calculateResult(input)).isEqualTo(result);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "1 ! 2",
            "1 + 2 # 3",
            "2 * 3 ! 5",
            "6 ( 1 ~ 5",
            "9 ) 7 $ 8",
    })
    void 유효하지_않은_연산자_테스트 (String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculateResult(input));
    }

    @DisplayName("0으로 나누었을 경우 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = "4 + 3 * 2 / 0")
    public void 모든값은_0으로_나눌수_없다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> StringCalculator.calculateResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}