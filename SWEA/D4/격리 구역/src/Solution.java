import java.util.*;

public class Solution {
    static List<int[][]> li;
    static int max;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            li = new ArrayList<>();
            max = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[][] map = new int[N][M];
            int[][] make = new int[N][M];

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    map[j][k] = sc.nextInt();
                    make[j][k] = map[j][k];
                }
            }
            dfs(map, N, M, K, 0, make, 0);

            for(int j = 0; j < li.size(); j++) {
                int[][] target = li.get(j);
                int count = bfs(target, N, M);
                max = Math.max(max, count);
            }
            System.out.println("#" + i + " " + max);
        }
    }
    static void dfs(int[][] map, int N, int M, int K, int depth, int[][] make, int start) {
        if(depth == K) {
            int[][] copy = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    copy[i][j] = make[i][j];
                }
            }
            li.add(copy);
            return;
        }
        for(int i = start; i < N*M; i++) {
            int x = i / M;
            int y = i % M;

            if(map[x][y] == 0) {
                make[x][y] = 2;
                dfs(map, N, M, K, depth+1, make, i+1);
                make[x][y] = map[x][y];
            }
        }
    }
    static int bfs(int[][] target, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(target[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + row[dir];
                int ny = y + col[dir];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(target[nx][ny] == 0) {
                        target[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // 안전 구역 개수 세기
        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(target[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}