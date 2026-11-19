import java.util.*;

public class Solution{
    static int max;
    static int[][] fixState;
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            max = Integer.MIN_VALUE;
            int N = sc.nextInt(); // 도시 격자의 크기
            int K = sc.nextInt(); // 수리해야 하는 신호탑의 개수
            int R = sc.nextInt(); // 모든 신호탑에 공통적으로 적용되는 신호 범위

            int[][] city = new int[N][N];
            fixState = new int[N][N];
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    city[j][k] = sc.nextInt();
                    if(city[j][k] == 1) fixState[j][k] = 2;
                }
            }
            dfs(city, N, K, R, 0, 0, 0);

            System.out.println("#" + i + " " + max);
        }
    }
    static void dfs(int[][] city, int N, int K, int R, int depth, int count, int start) {
        if(depth == K) {
            max = Math.max(max, count);
            return;
        }
        for(int idx = start; idx < N*N; idx++) {
            int i = idx / N;
            int j = idx % N;
            if(city[i][j] == 1) {
                int[][] backup = new int[N][N];
                for(int a = 0; a < N; a++) {
                    for(int b = 0; b < N; b++) {
                        backup[a][b] = fixState[a][b];
                    }
                }
                dfs(city, N, K, R, depth+1, count+fix(city, i, j, R), idx+1);
                fixState = backup;
            }
        }
    }
    static int fix(int[][] city, int i , int j, int R) {
        int len = city.length;
        int count = 0;
        if(fixState[i][j] == 2) {
            fixState[i][j] = 1;
            count = 1;
        }
        for(int dir = 0; dir < 4; dir++) {
            int range = 0;
            int ni = i + row[dir];
            int nj = j + col[dir];
            while(ni >= 0 && ni < len && nj >= 0 && nj < len) {
                if(fixState[ni][nj] != 1) {
                    count++;
                    fixState[ni][nj] = 1;
                }
                range++;
                ni += row[dir];
                nj += col[dir];
                if(range == R) break;
            }
        }
        return count;
    }
} 