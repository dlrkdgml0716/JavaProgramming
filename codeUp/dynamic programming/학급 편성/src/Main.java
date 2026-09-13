import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int stds = sc.nextInt();
        int maxStds = sc.nextInt();

        int[][] dp = new int[stds+1][maxStds+1];
        for(int i = 0; i <= maxStds; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i <= stds; i++){
            for(int j = 1; j <= maxStds; j++){
                if(j > i){
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i][j-1] + dp[i-j][j];
                }
            }
        }
        System.out.print(dp[stds][maxStds]);
    }
}