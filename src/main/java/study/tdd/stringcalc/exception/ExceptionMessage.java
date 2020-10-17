package study.tdd.stringcalc.exception;

public final class ExceptionMessage {
    // 생성자 방어
    private ExceptionMessage() { }

    public static final String DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다.";
    public static final String NOT_ARITHMETIC_SIMBOL = "사칙 연산 기호가 아닙니다.";
    public static final String INPUT_VALUE_EMPTY = "입력 값이 비어 있습니다.";
}
