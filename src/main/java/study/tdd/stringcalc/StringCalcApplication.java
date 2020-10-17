package study.tdd.stringcalc;

import study.tdd.stringcalc.domain.StringCalculator;

import java.util.Scanner;

public class StringCalcApplication {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        System.out.println(StringCalculator.calculateResult(input));
    }
}
