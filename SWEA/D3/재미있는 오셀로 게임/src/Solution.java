import java.util.*;

public class Solution {

    static int N;
    static int[][] map;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            int M = sc.nextInt();

            map = new int[N][N];

            map[N/2-1][N/2-1] = 2;
            map[N/2][N/2] = 2;
            map[N/2-1][N/2] = 1;
            map[N/2][N/2-1] = 1;

            for (int i = 0; i < M; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int color = sc.nextInt();

                map[x][y] = color;

                for (int d = 0; d < 8; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    while (nx >= 0 && nx < N &&
                            ny >= 0 && ny < N &&
                            map[nx][ny] != 0 &&
                            map[nx][ny] != color) {

                        nx += dx[d];
                        ny += dy[d];
                    }

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;

                    if (map[nx][ny] == color) {

                        int fx = x + dx[d];
                        int fy = y + dy[d];

                        while (fx != nx || fy != ny) {
                            map[fx][fy] = color;

                            fx += dx[d];
                            fy += dy[d];
                        }
                    }
                }
            }

            int black = 0;
            int white = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) black++;
                    else if (map[i][j] == 2) white++;
                }
            }

            System.out.println("#" + t + " " + black + " " + white);
        }
    }
}