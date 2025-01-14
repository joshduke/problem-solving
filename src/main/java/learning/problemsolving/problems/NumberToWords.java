package learning.problemsolving.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberToWords {

    private static final String[] ONES = { "", "One", "Two", "Three", "Four",
    "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Seventeen","Eighteen", "Nineteen"};

    private static final String[] TENS = { "", "", "Twenty", "Thirty", "Fourty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};


    private String getWordForNumberChunk(int num) {
        List<String> words = new ArrayList<>();
        if(num >= 100) {
            words.add(ONES[ num / 100] + " Hundred" );
            num = num%100;
        }

        if(num >= 20) {
            words.add(TENS[ num / 10]);
            num = num % 10;
        }

        if(num > 0) {
            words.add(ONES[num]);
        }
        return words.stream().filter(word -> !word.isEmpty()).collect(Collectors.joining(" "));
    }

    private String getWordsForNumber(int number) {
        if(number == 0) {
            return "Zero";
        }

        List<String> numLetters = new ArrayList<>();
        int thousandIndex = 0;
        while(number > 0) {
            int chunk = number % 1000;
            if(chunk > 0) {
                int index = thousandIndex;
                String chunkWord = getWordForNumberChunk(chunk);
                numLetters.add(chunkWord + (index > 0 ? " " + THOUSANDS[index] : ""));
            }
            number = number / 1000;
            thousandIndex++;
        }
        return IntStream.range(0, numLetters.size()).
                mapToObj(i -> numLetters.get(numLetters.size()-1-i))
                .filter(letter -> !letter.isEmpty())
                .collect(Collectors.joining(" "));

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        System.out.println(new NumberToWords().getWordsForNumber(number));

        String s = sc.nextLine();
        System.out.println(s.substring(s.indexOf("=")+2, s.length()));
        System.out.println("Output: \"" + new NumberToWords().getWordsForNumber(123) + "\"");

    }

}
