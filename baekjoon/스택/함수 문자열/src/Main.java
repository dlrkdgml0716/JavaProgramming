import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char cmd = s.charAt(i);

            if (cmd == 'x') {
                stack.push(0);
            }
            else if (cmd == 'g') {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                    return;
                }
                stack.push(stack.pop() + 1);
            }
            else if (cmd == 'f') {
                if (stack.size() < 2) {
                    System.out.println("-1");
                    return;
                }
                int s1 = stack.pop();
                int s2 = stack.pop();
                stack.push(Math.min(s1, s2));
            }
        }
        if (stack.size() == 1) {
            System.out.println(stack.pop());
        } else {
            System.out.println("-1");
        }
    }
}