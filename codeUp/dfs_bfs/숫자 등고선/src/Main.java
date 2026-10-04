import java.util.*;

class Main {
    static int[] row = {-1, 1, 0, 0};
    static int[] col = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];

        int x = sc.nextInt();
        int y = sc.nextInt();

        boolean[][] visited = new boolean[n][n];
        x--;
        y--;
        map[x][y] = 1;
        visited[x][y] = true;

        solve(n, map, x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void solve(int n, int[][] map, int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + row[i];
                int ny = cy + col[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}