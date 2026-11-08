import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            long A = sc.nextLong();
            long answer = 1;

            for (long j = 2; j <= A / j; j++) {
                int count = 0;

                while (A % j == 0) {
                    A /= j;
                    count++;
                }

                if (count % 2 == 1) {
                    answer *= j;
                }
            }

            if (A > 1) {
                answer *= A;
            }

            System.out.println("#" + i + " " + answer);
        }
    }
}