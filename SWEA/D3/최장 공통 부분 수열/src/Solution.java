import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            int N = s1.length();
            int M = s2.length();

            int[][] dp = new int[N+1][M+1];
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= M; k++) {
                    if(s1.charAt(j-1) == s2.charAt(k-1)) {
                        dp[j][k] = dp[j-1][k-1] + 1;
                    } else {
                        dp[j][k] = Math.max(dp[j-1][k], dp[j][k-1]);
                    }
                }
            }
            System.out.println("#" + i + " " + dp[N][M]);
        }
    }
}