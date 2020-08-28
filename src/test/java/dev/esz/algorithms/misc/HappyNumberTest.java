package dev.esz.algorithms.misc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HappyNumberTest {

    @Test
    @DisplayName("should return false in case of 12 which is not a happy number")
    void notHappyNumberTest() {
        assertThat(HappyNumber.find(12)).isFalse();
    }

    @Test
    @DisplayName("should return true in case of 23 which is a happy number")
    void happyNumberTest() {
        assertThat(HappyNumber.find(23)).isTrue();
    }
}
