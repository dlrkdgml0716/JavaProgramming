import java.util.Scanner;

public class Solution{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt(); // 정사각형 크기
            int K = sc.nextInt(); // 명령 횟수

            int[][] map = new int[N][N];
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    map[j][k] = sc.nextInt();
                }
            }

            String command = sc.next();
            for(int j = 0; j < K; j++) {
                int[][] result = new int[N][N];
                if(command.charAt(j) == 'R') {
                    for(int k = 0; k < N; k++) {
                        for(int l = 0; l < N; l++) {
                            result[l][N-k-1] = map[k][l];
                        }
                    }
                }
                else {
                    for(int k = 0; k < N; k++) {
                        for(int l = 0; l < N; l++) {
                            result[N-l-1][k] = map[k][l];
                        }
                    }
                }
                map = result;
            }

            int sum = 0;
            for(int j = 0; j < N; j++) {
                sum += map[j][j];
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}