import java.util.*;

public class Solution{
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            int N = sc.nextInt();
            sc.nextLine();
            int[][] map = new int[N][N];
            for(int j = 0; j < N; j++){
                String s = sc.nextLine();
                for(int k = 0; k < N; k++){
                    map[j][k] = s.charAt(k) - '0';
                }
            }

            int sum = 0;
            for(int j = 0; j < N; j++){
                int start = Math.abs(j - (N / 2));
                for(int k = start; k < N-start; k++){
                    sum += map[j][k];
                }
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}