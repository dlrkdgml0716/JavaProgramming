import java.util.*;

class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int MOD = 10007;
        int[][] dp = new int[n][10];

        for (int d = 0; d <= 9; d++) dp[0][d] = 1;

        for (int len = 1; len < n; len++) {
            for (int d = 0; d <= 9; d++) {
                for (int k = 0; k <= d; k++) {
                    dp[len][d] = (dp[len][d] + dp[len - 1][k]) % MOD;
                }
            }
        }

        int ans = 0;
        for (int d = 0; d <= 9; d++) ans = (ans + dp[n-1][d]) % MOD;
        System.out.println(ans);
    }
}