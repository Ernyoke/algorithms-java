package dev.esz.algorithms.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringKDistinctCharactersTest {


    @Test
    @DisplayName("should calculate the length of the longest substring with 3 distinct characters")
    void longestSubstringKDistinctCharacterTest() {
        String string = "cbbebi";
        assertThat(LongestSubstringKDistinctCharacters.longestSubstringKDistinctCharacter(string, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("should calculate the length of the longest substring with 2 distinct characters")
    void longestSubstringKDistinctCharacterTest2() {
        String string = "araaci";
        assertThat(LongestSubstringKDistinctCharacters.longestSubstringKDistinctCharacter(string, 2)).isEqualTo(4);
    }
}
