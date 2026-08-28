class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int[] solution(int m, int n, int[][] picture) {
        int countArea = 0;
        int max = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    countArea++;
                    int currentAreaSize = solve(i, j, picture[i][j], visited, picture, m, n);
                    max = Math.max(max, currentAreaSize);
                }
            }
        }
        return new int[]{countArea, max};
    }
    public int solve(int x, int y, int currentColor, boolean[][] visited, int[][] picture, int m, int n) {
        visited[x][y] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (picture[nx][ny] == currentColor && !visited[nx][ny]) {
                    size += solve(nx, ny, currentColor, visited, picture, m, n);
                }
            }
        }
        return size;
    }
}