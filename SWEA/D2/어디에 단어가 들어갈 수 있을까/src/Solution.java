import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] map = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = sc.nextInt();
                }
            }
            int result = 0;
            for (int i = 0; i < N; i++) {
                int horizontal = 0;
                int vertical = 0;
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        horizontal++;
                    } else {
                        if (horizontal == K) {
                            result++;
                        }
                        horizontal = 0;
                    }
                    if (map[j][i] == 1) {
                        vertical++;
                    } else {
                        if (vertical == K) {
                            result++;
                        }
                        vertical = 0;
                    }
                }
                if (horizontal == K) {
                    result++;
                }
                if (vertical == K) {
                    result++;
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}