package learning.problemsolving.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterCombinationsStream {

    private List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return List.of();
        }

        // Mapping from digits to corresponding letters
        Map<Character, String> digitToLetters = Map.of(
                '2', "abc", '3', "def", '4', "ghi",
                '5', "jkl", '6', "mno", '7', "pqrs",
                '8', "tuv", '9', "wxyz"
        );

        // Start with a stream containing an empty string
        Stream<String> combinations = Stream.of("");

        // Reduce the stream by mapping each digit to its letters
        for (char digit : digits.toCharArray()) {
            String letters = digitToLetters.getOrDefault(digit, "");
            combinations = combinations.flatMap(combination ->
                    letters.chars().mapToObj(c -> combination + (char) c)
            );
        }
        return combinations.collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
//        String input = "2";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<String> result = new LetterCombinationsStream().letterCombinations(input);
        System.out.println(result); // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}

