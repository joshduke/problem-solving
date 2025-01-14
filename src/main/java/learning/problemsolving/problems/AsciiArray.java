package learning.problemsolving.problems;

public class AsciiArray {

    public static void main(String [] args) {
        String input = "abcdefghijklmnopqrstuvwxyz";
        int[] chars = new int[26];
        char[] charArr = new char[26];
        for(char ch : input.toCharArray()) {
            System.out.print((int)ch + "\t");
            chars[((int)ch)%26] = (int)ch;
            charArr[((int)ch)%26] = ch;
        }

        for(char c : charArr) {
            System.out.print(c);
        }
    }

}
