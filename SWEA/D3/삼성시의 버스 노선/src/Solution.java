import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            int N = sc.nextInt();
            int[][] way = new int[N][2];
            for(int j = 0; j < N; j++){
                for(int k = 0; k < 2; k++){
                    way[j][k] = sc.nextInt();
                }
            }

            int P = sc.nextInt();
            int[] platform = new int[P];
            for(int j = 0; j < P; j++){
                platform[j] = sc.nextInt();
            }
            int[] result = new int[P];
            for(int j = 0; j < P; j++){
                for(int k = 0; k < N; k++){
                    if(platform[j] >= way[k][0] && platform[j] <= way[k][1]) result[j]++;
                }
            }

            System.out.print("#" + i + " ");
            for(int j = 0; j < result.length; j++){
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }
}