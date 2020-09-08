package dev.esz.algorithms.backtracking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BalancedParenthesesTest {

    @Test
    @DisplayName("should return a list of strings with all the existing solutions for balancing N number of pairs of parentheses")
    void generateValidParenthesesTest() {
        assertThat(BalancedParentheses.generateValidParentheses(2)).containsExactlyInAnyOrder("(())", "()()");
    }

    @Test
    @DisplayName("should return a list of strings with all the existing solutions for balancing N number of pairs of parentheses")
    void generateValidParenthesesTest2() {
        assertThat(BalancedParentheses.generateValidParentheses(3)).containsExactlyInAnyOrder(
                "((()))", "(()())", "(())()", "()(())", "()()()"
        );
    }
}
