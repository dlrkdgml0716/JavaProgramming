import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        int[] col = {0, 1, 0, -1};
        int[] row = {1, 0, -1, 0};

        for(int i = 0; i < testCase; i++){
            int size = sc.nextInt();
            int[][] map = new int[size][size];

            int c = 0;
            int r = 0;
            int dir = 0;

            for(int j = 1; j <= size*size; j++){
                map[c][r] = j;
                if(j == size*size) break;

                int nc = col[dir] + c;
                int nw = row[dir] + r;
                if(nc < 0 || nc >= size || nw < 0 || nw >= size || map[nc][nw] != 0){
                    dir = (dir+1) % 4;
                }
                c += col[dir];
                r += row[dir];
            }
            System.out.println("#" + (i+1));
            for(int j = 0; j < size; j++){
                for(int k = 0; k  < size; k++) {
                    System.out.print(map[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}