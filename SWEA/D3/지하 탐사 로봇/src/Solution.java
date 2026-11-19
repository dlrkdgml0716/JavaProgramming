import java.util.*;

public class Solution{
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            max = 0;
            int N = sc.nextInt(); // 연구시설의 행 개수
            int M = sc.nextInt(); // 연구시설의 열 개수
            int K = sc.nextInt(); // 로봇이 이동할 수 있는 최대 횟수

            int[][] map = new int[N][M];
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    map[j][k] = sc.nextInt();
                }
            }

            dfs(map, K, 0, 0, 0, 0);

            System.out.println("#" + i + " " + max);
        }
    }
    static void dfs(int[][] map, int K, int depth, int collection, int x, int y) {
        max = Math.max(max, collection);
        if(depth == K) {
            return;
        }
        for(int dir = 0; dir < 4; dir++) {
            int nx = x + row[dir];
            int ny = y + col[dir];
            if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                if(map[nx][ny] == 2) {

                    map[nx][ny] = 0;
                    dfs(map, K, depth+1, collection+1, nx, ny);
                    map[nx][ny] = 2;
                }
                else if(map[nx][ny] == 0) {
                    dfs(map, K, depth+1, collection, nx, ny);
                }
            }
        }
    }
} 