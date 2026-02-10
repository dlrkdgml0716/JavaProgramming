import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String formula = sc.next();
        Stack<Integer> stack = new Stack<>();

        for (char ch : formula.toCharArray()) {
            if (ch == '(') {
                stack.push(-1);
            } else if (ch == ')') {
                int tempSum = 0;
                while (stack.peek() != -1) {
                    tempSum += stack.pop();
                }
                stack.pop();
                stack.push(tempSum);
            } else if (Character.isDigit(ch)) {
                int multiplier = ch - '0';
                int lastValue = stack.pop();
                stack.push(lastValue * multiplier);
            } else {
                stack.push(getWeight(ch));
            }
        }

        int totalWeight = 0;
        while (!stack.isEmpty()) {
            totalWeight += stack.pop();
        }
        System.out.println(totalWeight);
    }
    private static int getWeight(char c) {
        int score = 0;
        switch (c) {
            case 'H': score = 1; break;
            case 'C': score = 12; break;
            case 'O': score = 16; break;
            default: break;
        };
        return score;
    }
}