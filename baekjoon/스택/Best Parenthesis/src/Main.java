import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long MOD = 12345678910L;
        Stack<Long> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                stack.push(-1L);
            }
            else {
                if (stack.peek() == -1L) {
                    stack.pop();
                    stack.push(1L);
                } else {
                    long innerSum = 0;
                    while (!stack.isEmpty() && stack.peek() != -1L) {
                        innerSum = (innerSum + stack.pop()) % MOD;
                    }

                    if (!stack.isEmpty() && stack.peek() == -1L) {
                        stack.pop();
                        stack.push((innerSum * 2) % MOD);
                    }
                }
            }
        }

        long finalResult = 0;
        while (!stack.isEmpty()) {
            long val = stack.pop();
            finalResult = (finalResult + val) % MOD;
        }
        System.out.println(finalResult);
    }
}