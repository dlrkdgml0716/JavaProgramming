import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.empty()) stack.push(c);
            else{
                if(c == ')' && stack.peek() == '(') stack.pop();
                else if(c == ')') stack.push(c);
                else if(c == '(') stack.push(c);
            }
        }
        System.out.print(stack.size());
    }
}