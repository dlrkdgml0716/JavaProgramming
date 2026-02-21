import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        String s = scanner.nextLine();
        String[] arr = s.split(" ");

        Stack<Long> stack = new Stack<>();

        for (String token : arr) {
            if (token.equals("[")) {
                stack.push(0L);
            }
            else if (token.equals("]")) {
                long currentLevelSum = stack.pop();
                long objectSize = currentLevelSum + 8;

                if (stack.isEmpty()) {
                    System.out.println(objectSize);
                } else {
                    long parentLevelSum = stack.pop();
                    stack.push(parentLevelSum + objectSize);
                }
            }
            else if (token.matches("^[1-9][0-9]{0,16}$")) {
                long currentLevelSum = stack.pop();
                stack.push(currentLevelSum + 8);
            }
            else if (token.matches("^[a-zA-Z]+$")) {
                long currentLevelSum = stack.pop();
                stack.push(currentLevelSum + token.length() + 12);
            }
        }
    }
}