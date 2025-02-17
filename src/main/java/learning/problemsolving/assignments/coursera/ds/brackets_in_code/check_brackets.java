package learning.problemsolving.assignments.coursera.ds.brackets_in_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                Bracket b = new Bracket(next, position);
                opening_brackets_stack.push(b);
            } else if (next == ')' || next == ']' || next == '}') {
                if(!opening_brackets_stack.isEmpty()) {
                    // Process closing bracket, write your code here
                    Bracket from_stack = opening_brackets_stack.peek();
                    if(from_stack.Match(next)) {
                        opening_brackets_stack.pop();
                    } else { // closing bracket didn't match
                        System.out.print(position + 1);
                        return;
                    }
                } else {
                    System.out.print(position + 1);
                    return;
                }
            }
        }
        if(opening_brackets_stack.empty()) {
            System.out.print("Success");
        } else {
            System.out.print(opening_brackets_stack.pop().position + 1);
        }
    }
}
