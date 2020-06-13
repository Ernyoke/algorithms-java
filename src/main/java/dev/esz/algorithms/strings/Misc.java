package dev.esz.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Misc {
    static boolean isPalindrome(String string) {
        int middle = string.length() / 2;
        for (int i = 0; i < middle; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static Map<Character, Integer> histogram(String string) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (char c : string.toCharArray()) {
            characterMap.compute(c, (key, value) -> value == null ? 1 : value + 1);
        }
        return characterMap;
    }

    static boolean isAnagram(String a, String b) {
        Map<Character, Integer> histogramA = histogram(a);
        Map<Character, Integer> histogramB = histogram(b);
        if (histogramA.keySet().size() != histogramB.keySet().size()) {
            return false;
        }
        return histogramB.keySet().stream().allMatch(key -> histogramB.get(key).equals(histogramA.get(key)));
    }

    // Group anagrams together into lists. Return a list of lists with anagram groups.
    // https://www.algoexpert.io/questions/Group%20Anagrams
    static List<List<String>> groupAnagrams(List<String> strings) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        if (strings.size() > 0) {
            anagramGroups.put(strings.get(0), new ArrayList<>(List.of(strings.get(0))));
            for (int i = 1; i < strings.size(); i++) {
                String string = strings.get(i);
                boolean anagramFound = false;
                for (String otherString : new ArrayList<>(anagramGroups.keySet())) {
                    if (isAnagram(otherString, string)) {
                        anagramGroups.get(otherString).add(string);
                        anagramFound = true;
                        break;
                    }
                }
                if (!anagramFound) {
                    anagramGroups.put(string, new ArrayList<>(List.of(string)));
                }
            }
        }
        return new ArrayList<>(anagramGroups.values());
    }


}
