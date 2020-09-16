package dev.esz.algorithms.misc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BattleShipTest {

    @Test
    void solution() {
        assertThat(new BattleShip().solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A")).isEqualTo("1,1");
    }
}
