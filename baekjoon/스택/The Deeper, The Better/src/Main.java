import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int maxScore = 0;
        int currentScore = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') currentScore += 1;
            else if (c == '{') currentScore += 2;
            else if (c == '[') currentScore += 3;

            else if (c == ')') currentScore -= 1;
            else if (c == '}') currentScore -= 2;
            else if (c == ']') currentScore -= 3;

            else if (Character.isDigit(c)) {
                if (currentScore > maxScore) {
                    maxScore = currentScore;
                }
            }
        }

        System.out.println(maxScore);
        sc.close();
    }
}