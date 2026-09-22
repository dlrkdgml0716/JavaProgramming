import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] num = new double[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextDouble();
        }

        double[] dp = new double[n];
        double max = 0;
        dp[0] = num[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(num[i], dp[i - 1] * num[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.printf("%.3f%n", max);
    }
}