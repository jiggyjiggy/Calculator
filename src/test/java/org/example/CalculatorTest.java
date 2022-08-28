package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;


/*
 * 구현 사항
 * - 사칙연산
 * - 양수로만 계산
 * - 나눗셈에서 0으로 나누는 경우 IllegalArgument 예외를 발생시킨다
 * - MVC(Model-View-Controller) pattern 으로 구현한다
 * */
public class CalculatorTest {

    // 1 + 2 ------> Calculator
    //   3   <------
    @DisplayName("사칙 연산을 정상적으로 수행한다")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void additionTest(int operand1, String operator, int operand2, int result) {
        int calculatorResult = Calculator.calculate(operand1, operator, operand2);

        assertThat(calculatorResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }

    @DisplayName("나눗셈에서 0으로 나누는 경우, IllegalArgument 예외를 발생시킨다.")
    @Test
    void calculatorExceptionTest() {
        assertThatCode(() -> Calculator.calculate(10, "/", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}
