import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(c);
            else if(!stack.empty() && c == ')' && stack.peek() == '(') stack.pop();
            else if(!stack.empty() && c == '*'){
                while(!stack.empty()){
                    count++;
                    stack.pop();
                }
            }
        }
        System.out.print(count);
    }
}