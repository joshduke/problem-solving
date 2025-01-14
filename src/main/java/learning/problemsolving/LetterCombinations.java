package learning.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return List.of();
        }

        // Mapping from digits to corresponding letters
        String[] digitToLetters = {
                "",    // 0
                "",    // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz" // 9
        };

        List<String> combinations = new ArrayList<>();
        backtrack(combinations, new StringBuilder(), digits, 0, digitToLetters);
        return combinations;
    }

    private static void backtrack(List<String> combinations, StringBuilder currentCombination,
                                  String digits, int index, String[] digitToLetters) {
        if (index == digits.length()) {
            combinations.add(currentCombination.toString());
            return;
        }

        String letters = digitToLetters[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(combinations, currentCombination, digits, index + 1, digitToLetters);
            currentCombination.deleteCharAt(currentCombination.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        String input = "23";
        List<String> result = letterCombinations(input);
        System.out.println(result); // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
