package study.tdd.stringcalc.domain;

import org.springframework.util.StringUtils;
import study.tdd.stringcalc.exception.ExceptionMessage;
import study.tdd.stringcalc.util.StringUtil;

public class StringCalculator {

    /**
     * Operator.result(operator, firstValue, secondValue))
     * 연산은 Operator로 위임한다.
     */
    public static int calculate(String[] splitInput) {
        int result = StringUtil.toInt(splitInput[0]);
        for (int i = 2; i < splitInput.length; i += 2) {
            result = Operator.result(splitInput[i-1], result, StringUtil.toInt(splitInput[i]));
        }
        return result;
    }

    public static int calculateResult(String input) {
        isBlank(input);
        return calculate(StringUtil.split(input));
    }

    /* validation check*/
    public static void isBlank(String input) {
        if (StringUtils.isEmpty(input) || input.equals(" ")) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE_EMPTY);
        }
    }
}
