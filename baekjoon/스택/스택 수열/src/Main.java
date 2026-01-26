import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int last_value = 0;

        for (int i = 0; i < N; i++) {
            int target = sc.nextInt();

            if (target > last_value) {
                for (int j = last_value + 1; j <= target; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                last_value = target;
            }
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}