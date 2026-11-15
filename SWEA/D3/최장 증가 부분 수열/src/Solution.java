import java.util.*;

public class Solution {
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            max = 0;
            int N = sc.nextInt();

            long[] num = new long[N];
            int[] dp = new int[N];

            for(int j = 0; j < N; j++) {
                num[j] = sc.nextLong();
                dp[j] = 1;
            }

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < j; k++) {
                    if(num[k] < num[j]) {
                        dp[j] = Math.max(dp[j], dp[k]+1);
                    }
                }
                max = Math.max(max, dp[j]);
            }
            System.out.println("#" + i + " " + max);
        }
    }
}