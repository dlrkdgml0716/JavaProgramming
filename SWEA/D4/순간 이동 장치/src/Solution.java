import java.util.*;

public class Solution {
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    static int min;
    static Queue<int[]> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++){
                    map[j][k] = sc.nextInt();
                }
            }
            queue = new LinkedList<>();
            min = bfs(map, N, 0, 0, 0);
            System.out.println("#" + i + " " + min);
        }
    }
    static int bfs(int[][] map, int N, int x, int y, int move) {
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[] {x, y, move});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] next = queue.poll();
            int cx = next[0];
            int cy = next[1];
            int count = next[2];
            if(cx == N-1 && cy == N-1) {
                return count;
            }
            if(map[cx][cy] >= 2) {
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < N; k++){
                        if(map[cx][cy] == map[j][k] && !visited[j][k]) {
                            visited[j][k] = true;
                            queue.add(new int[] {j, k, count+1});
                        }
                    }
                }
            }
            for(int i = 0; i < 4; i++) {
                int nx = cx + row[i];
                int ny = cy + col[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(map[nx][ny] != 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny, count+1});
                    }
                }
            }
        }
        return -1;
    }
}