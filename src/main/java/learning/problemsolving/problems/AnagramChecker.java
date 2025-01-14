package learning.problemsolving.problems;

import java.util.Arrays;

public class AnagramChecker {

    public static void main(String[] args) {
        String s1 = "abca";
        String s2 = "baca";
        System.out.println(new AnagramChecker().isAnagram(s1, s2)) ;
    }


    private boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        int ALPHABETS_COUNT = 26;
        int[] counts = new int[ALPHABETS_COUNT];
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(char ch : str1.toCharArray()) {
            counts[ch % ALPHABETS_COUNT]++;
        }

        Arrays.stream(counts).forEach(System.out::print);

        for(char ch : str2.toCharArray()) {
            counts[ch % ALPHABETS_COUNT]--;
        }

//        str1.chars().mapToObj(ch -> counts[ch % ALPHABETS_COUNT]++);

        for(int count : counts) {
            System.out.print(count + "\t");
            if(count != 0) {
                return false;
            }
        }

//        str2.chars().mapToObj(ch -> counts[ch % ALPHABETS_COUNT]--);


        return true;
    }

}
