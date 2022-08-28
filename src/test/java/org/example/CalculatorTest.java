package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


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
    @DisplayName("덧셈 연산을 정상적으로 수행한다")
    @Test
    void additionTest() {
        int result = Calculator.calculator(1, "+", 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 정상적으로 수행한다")
    @Test
    void subtrationTest() {
        int result = Calculator.calculator(1, "-", 2);

        assertThat(result).isEqualTo(-1);
    }
}
