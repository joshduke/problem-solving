package learning.problemsolving.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LetterCombinationPractice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(new LetterCombinationPractice().generateCombinations(input));
    }

    private List<String> generateCombinations(String input) {
        if(input == null || input.isEmpty()) {
            return List.of();
        }

        Map<Character, String> digitMap = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno",
                '7', "pqr", '8', "tuv", '9', "wxyz"
        );

        Stream<String> combinations = Stream.of("");

        for(char digit: input.toCharArray()) {
            String letters = digitMap.getOrDefault(digit, "");
            combinations = combinations.flatMap(combination -> letters.chars().mapToObj(c -> combination + (char) c));
        }
        return combinations.collect(Collectors.toList());
    }

}
