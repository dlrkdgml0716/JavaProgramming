import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }

        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = coins[0];
        dp[0][2] = 0;
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1] = dp[i-1][0] + coins[i];
            dp[i][2] = dp[i-1][1] + coins[i];
        }
        System.out.print(Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])));
    }
}