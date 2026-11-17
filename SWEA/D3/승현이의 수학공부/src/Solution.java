import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            String X = sc.next();

            int sum = 0;
            for(int j = 0; j < X.length(); j++) {
                sum += X.charAt(j) - '0';
            }

            System.out.println("#" + i + " " + (sum%(N-1)));
        }
    }
}