import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int fix = sc.nextInt();

        boolean[] fixed = new boolean[total+1];
        for(int i = 0; i < fix; i++){
            fixed[sc.nextInt()] = true;
        }

        int[] dp = new int[total+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            dp[i] = dp[i-1];
            if(!fixed[i] && !fixed[i-1]){
                dp[i] += dp[i-2];
            }
        }
        System.out.print(dp[total]);
    }
}