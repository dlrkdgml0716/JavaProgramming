import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] child = new int[n];
        for(int i = 0; i < n; i++){
            child[i] = scanner.nextInt();
        }

        int lis = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(child[j] < child[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j]+1;
                }
            }
            if(lis < dp[i]) lis = dp[i];
        }
        System.out.print(n-lis);
    }
}