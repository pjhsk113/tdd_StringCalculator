package study.tdd.stringcalc.domain;

import study.tdd.stringcalc.exception.ExceptionMessage;
import study.tdd.stringcalc.util.StringUtil;

public class StringCalculator {

    public static int calculateResult(String input) {
        isBlank(input);
        return calculate(StringUtil.split(input));
    }

    /**
     * Operator.result(operator, firstValue, secondValue))
     * 연산은 Operator로 위임한다.
     */
    private static int calculate(String[] splitInput) {
        int result = StringUtil.toInt(splitInput[0]);
        for (int i = 2; i < splitInput.length; i += 2) {
            result = Operator.result(splitInput[i-1], result, StringUtil.toInt(splitInput[i]));
        }
        return result;
    }

    /* validation check*/
    private static void isBlank(String input) {
        if (input.isEmpty() || input.equals(" ")) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE_EMPTY);
        }
    }
}
