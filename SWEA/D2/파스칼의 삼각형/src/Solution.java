import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int[][] top = new int[N][N];

            System.out.println("#" + (i+1));
            for(int j = 0; j < N; j++){
                for(int k = 0; k <= j; k++){
                    if(k == 0 || k == N-1) top[j][k] = 1;
                    else {
                        top[j][k] = top[j-1][k-1] + top[j-1][k];
                    }
                    System.out.print(top[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}