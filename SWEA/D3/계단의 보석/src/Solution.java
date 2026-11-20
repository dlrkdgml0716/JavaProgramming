import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt(); // 계단 층수
            int[] gem = new int[N+1];
            for(int j = 1; j <= N; j++) {
                gem[j] = sc.nextInt();
            }

            int[] dp = new int[N+1];
            if(N >= 2) {
                dp[0] = 0;
                dp[1] = gem[1];
                dp[2] = gem[1]+gem[2];
                for(int j = 3; j < N+1; j++) {
                    dp[j] = Math.max(dp[j-2] + gem[j], dp[j-3] + gem[j-1] + gem[j]);
                }
            }
            else {
                System.out.println("#" + i + " " + gem[1]);
                continue;
            }

            System.out.println("#" + i + " " + dp[N]);
        }
    }
}