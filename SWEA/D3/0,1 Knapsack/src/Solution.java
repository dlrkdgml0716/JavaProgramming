import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] gem = new int[N][2];
            for(int j = 0; j < N; j++) {
                gem[j][0] = sc.nextInt(); // 부피
                gem[j][1] = sc.nextInt(); // 가치
            }

            int[][] dp = new int[N+1][K+1];
            for(int j = 1; j <= N; j++) {
                int weight = gem[j-1][0];
                int value = gem[j-1][1];

                for(int k = 0; k <= K; k++) {
                    if(k < weight) dp[j][k] = dp[j-1][k];
                    else dp[j][k] = Math.max(dp[j-1][k], dp[j-1][k - weight] + value);
                }
            }

            System.out.println("#" + i + " " + dp[N][K]);
        }
    }
}