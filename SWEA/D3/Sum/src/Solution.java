import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            int testCase = sc.nextInt();
            int[][] map = new int[100][100];

            for(int j = 0; j < 100; j++){
                for(int k = 0; k < 100; k++){
                    map[j][k] = sc.nextInt();
                }
            }
            int max1 = 0;
            for(int j = 0; j < 100; j++){
                int rowSum = 0;
                int colSum = 0;
                for(int k = 0; k < 100; k++){
                    rowSum += map[j][k];
                    colSum += map[k][j];
                }
                max1 = Math.max(max1, Math.max(rowSum, colSum));
            }
            int max2 = 0;
            int diagonal1 = 0;
            int diagonal2 = 0;
            for(int j = 0; j < 100; j++){
                diagonal1 += map[j][j];
                diagonal2 += map[j][99-j];
            }
            max2 = Math.max(diagonal1, diagonal2);
            System.out.println("#" + (i+1) + " " + Math.max(max1, max2));
        }
    }
}