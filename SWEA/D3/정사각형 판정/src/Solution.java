import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            sc.nextLine();

            char[][] map = new char[N][N];

            for(int j = 0; j < N; j++) {
                String s = sc.nextLine();
                for(int k = 0; k < N; k++) {
                    map[j][k] = s.charAt(k);
                }
            }

            int[] row = new int[N];
            int[] col = new int[N];

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(map[j][k] == '#') {
                        col[k]++;
                        row[j]++;
                    }
                }
            }

            int minRow = N;
            int maxRow = -1;
            int minCol = N;
            int maxCol = -1;

            for(int j = 0; j < N; j++) {
                if(row[j] > 0) {
                    minRow = Math.min(minRow, j);
                    maxRow = Math.max(maxRow, j);
                }

                if(col[j] > 0) {
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }

            boolean possible = true;
            if(maxRow == -1) {
                possible = false;
            }
            else {
                int height = maxRow - minRow + 1;
                int width = maxCol - minCol + 1;

                if(height != width) {
                    possible = false;
                }

                for(int j = minRow; j <= maxRow; j++) {
                    if(row[j] != width) {
                        possible = false;
                    }
                }
                for(int j = minCol; j <= maxCol; j++) {
                    if(col[j] != height) {
                        possible = false;
                    }
                }
            }
            System.out.println("#" + i + " " +
                    (possible ? "yes" : "no"));
        }
    }
}