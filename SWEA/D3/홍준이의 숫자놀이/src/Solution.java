import java.util.*;

public class Solution {
    static long x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            long A = sc.nextLong();
            long B = sc.nextLong();

            long gcd = extendedGcd(A, B);

            if (gcd != 1) {
                System.out.println("#" + i + " -1");
            } else {
                System.out.println("#" + i + " " + x + " " + y);
            }
        }

        sc.close();
    }

    static long extendedGcd(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }

        long gcd = extendedGcd(b, a % b);

        long temp = x;
        x = y;
        y = temp - (a / b) * y;

        return gcd;
    }
}