package dev.esz.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public interface LongestSubstringKDistinctCharacters {
    // Find the length of the longest substring in it with no more than K distinct characters.
    // https://www.educative.io/courses/grokking-the-coding-interview
    static int longestSubstringKDistinctCharacter(String string, int k) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        Map<Character, Integer> characterMap = new HashMap<>();
        int startPosition = 0;
        int endPosition = 0;
        int substringLength = 0;
        while (endPosition < string.length()) {
            Character startPosCharacter = string.charAt(endPosition);
            if ((characterMap.containsKey(startPosCharacter) && characterMap.entrySet().size() <= k) || characterMap.entrySet().size() < k) {
                characterMap.put(startPosCharacter, characterMap.getOrDefault(startPosCharacter, 0) + 1);
                substringLength = Math.max(substringLength, endPosition - startPosition + 1);
                endPosition++;
            } else {
                while (characterMap.entrySet().size() >= k) {
                    Character firstPosCharacter = string.charAt(startPosition);
                    int nr = characterMap.get(firstPosCharacter);
                    if (nr > 1) {
                        characterMap.put(firstPosCharacter, nr - 1);
                    } else {
                        characterMap.remove(firstPosCharacter);
                    }
                    startPosition++;
                }
            }
        }
        return substringLength;
    }
}
