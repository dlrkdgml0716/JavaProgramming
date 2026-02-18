import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] levels = new int[N];
        int[] childrenCount = new int[N];
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int currentLevel = levels[i];
            if (currentLevel > 1) {
                while (!stack.isEmpty() && levels[stack.peek()] >= currentLevel) {
                    stack.pop();
                }
                if (stack.isEmpty() || levels[stack.peek()] != currentLevel - 1) {
                    System.out.println("-1");
                    return;
                }
                int parentIdx = stack.peek();
                childrenCount[parentIdx]++;
            } else {
                stack.clear();
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int count : childrenCount) {
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}