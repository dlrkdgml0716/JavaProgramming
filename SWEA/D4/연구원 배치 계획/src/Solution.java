import java.util.*;

public class Solution{
    static List<int[]> li;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            li = new ArrayList<>();
            int N = sc.nextInt(); // 전체 연구원 수
            int M = sc.nextInt(); // 선발해야 하는 연구원 수
            int K = sc.nextInt(); // 갈등 관계의 개수

            int[][] point = new int[N+1][N+1];
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    point[j][k] = sc.nextInt();
                }
            }

            int[][] bad = new int[K][2];
            for(int j = 0; j < K; j++) {
                bad[j][0] = sc.nextInt();
                bad[j][1] = sc.nextInt();
            }

            int[] selected = new int[M];
            dfs(N, M, 1, 0, selected);

            int max = Integer.MIN_VALUE;
            for(int j = 0; j < li.size(); j++) {
                int[] target = li.get(j);
                boolean isPossible = true;
                for(int k = 0; k < K; k++) {
                    int a = bad[k][0];
                    int b = bad[k][1];

                    boolean foundA = false;
                    boolean foundB = false;

                    for(int l = 0; l < M; l++) {
                        if(target[l] == a) {
                            foundA = true;
                        }

                        if(target[l] == b) {
                            foundB = true;
                        }
                    }

                    if(foundA && foundB) {
                        isPossible = false;
                        break;
                    }
                }
                if(!isPossible) continue;
                int sum = 0;
                for(int k = 0; k < M-1; k++) {
                    for(int l = k+1; l < M; l++) {
                        sum += point[target[k]][target[l]];
                    }
                }
                max = Math.max(max, sum);
            }
            if(max == Integer.MIN_VALUE) {
                max = -1;
            }

            System.out.println("#" + i + " " + max);
        }
    }
    static void dfs(int N, int M, int start, int depth, int[] selected) {
        if(depth == M) {
            li.add(selected.clone());
            return;
        }
        for(int i = start; i <= N; i++) {
            selected[depth] = i;
            dfs(N, M, i + 1, depth + 1, selected);
        }
    }
}