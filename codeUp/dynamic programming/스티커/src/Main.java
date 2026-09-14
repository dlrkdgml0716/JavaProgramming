import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            int col = scanner.nextInt();
            int[][] set = new int[2][col];
            for(int j = 0; j < col*2; j++){
                int num = scanner.nextInt();
                if(j < col) set[0][j] = num;
                else set[1][j%col] = num;
            }
            int[][] dp = new int[3][col];
            dp[0][0] = 0;
            dp[1][0] = set[0][0];
            dp[2][0] = set[1][0];

            for (int c = 1; c < col; c++) {
                dp[0][c] = Math.max(dp[0][c-1], Math.max(dp[1][c-1], dp[2][c-1]));
                dp[1][c] = Math.max(dp[0][c-1], dp[2][c-1]) + set[0][c];
                dp[2][c] = Math.max(dp[0][c-1], dp[1][c-1]) + set[1][c];
            }
            System.out.println(Math.max(dp[0][col-1], Math.max(dp[1][col-1], dp[2][col-1])));
        }
    }
}