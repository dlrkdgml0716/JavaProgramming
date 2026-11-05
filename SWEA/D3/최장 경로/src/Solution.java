import java.util.*;

public class Solution{
    static int max;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            max = 0;
            int[][] map = new int[N+1][N+1];
            for(int j = 0; j < M; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
                map[y][x] = 1;
            }
            for (int j = 1; j <= N; j++) {
                boolean[] visited = new boolean[N + 1];

                visited[j] = true;
                dfs(map, N, j, 1, visited);
            }
            System.out.println("#" + i + " " + max);
        }
    }
    static void dfs(int[][] map, int N, int current, int count, boolean[] visited){
        max = Math.max(count, max);

        for(int i = 1; i <= N; i++){
            if(map[current][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(map, N, i, count+1, visited);
                visited[i] = false;
            }
        }
    }
}