import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int size = sc.nextInt();
            int[][] map = new int[size][size];

            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    map[j][k] = sc.nextInt();
                }
            }
            System.out.println("#" + (i+1));
            int[][] rotation1 = rotation(size, map);
            int[][] rotation2 =rotation(size, rotation1);
            int[][] rotation3 =rotation(size, rotation2);
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    System.out.print(rotation1[j][k]);
                }
                System.out.print(" ");
                for(int k = 0; k < size; k++){
                    System.out.print(rotation2[j][k]);
                }
                System.out.print(" ");
                for(int k = 0; k < size; k++){
                    System.out.print(rotation3[j][k]);
                }
                System.out.println();
            }
        }
    }
    static int[][] rotation(int size, int[][] map){
        int[][] temp = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                temp[i][j] = map[(size-1) - j][i];
            }
        }
        return temp;
    }
}