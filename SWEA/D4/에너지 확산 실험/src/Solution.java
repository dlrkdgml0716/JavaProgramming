import java.util.*;

public class Solution{
    static int[] row = {0, -1, 0, 1};
    static int[] col = {-1, 0, 1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt(); // 연구실 크기
            int K = sc.nextInt(); // 확산 횟수

            int[][] map = new int[N][N];
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    map[j][k] = sc.nextInt();
                }
            }


            int result = 0;
            for(int n = 0; n < K; n++) {
                int[][] next = new int[N][N];

                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < N; k++) {
                        next[j][k] = map[j][k];
                    }
                }
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < N; k++) {
                        int count = 0;
                        for(int l = 0; l < 4; l++) {
                            int nj = j + row[l];
                            int nk = k + col[l];
                            if(nj >= 0 && nj < N && nk >= 0 && nk < N) {
                                count++;
                            }
                        }
                        if(map[j][k] >= count && map[j][k] >= 2) {
                            result++;
                            next[j][k] -= count;
                            for(int l = 0; l < 4; l++) {
                                int nj = j + row[l];
                                int nk = k + col[l];
                                if(nj >= 0 && nj < N && nk >= 0 && nk < N) {
                                    next[nj][nk]++;
                                }
                            }
                        }
                    }
                }
                map = next;
            }
            int max = 0;
            System.out.print("#" + i + " ");
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    max = Math.max(max,  map[j][k]);
                }
            }
            System.out.println(max);
        }
    }
} 