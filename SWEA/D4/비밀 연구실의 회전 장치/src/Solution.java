import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt(); // 격자 크기
            int K = sc.nextInt(); // 회전 명령 횟수

            int[][] map = new int[N][N];
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    map[j][k] = sc.nextInt();
                }
            }

            for(int j = 0; j < K; j++) {
                int startRow = sc.nextInt();
                int startCol = sc.nextInt();
                int width = sc.nextInt();
                String dir = sc.next();

                int[][] temp = new int[width][width];
                for(int k = 0; k < width; k++) {
                    for(int l = 0; l < width; l++) {
                        temp[k][l] = map[k+startRow][l+startCol];
                    }
                }
                int[][] rotated = new int[width][width];
                for(int k = 0; k < width; k++) {
                    for(int l = 0; l < width; l++) {
                        if(dir.equals("R")) {
                            rotated[l][width-k-1] = temp[k][l];
                        }
                        else {
                            rotated[width-l-1][k] = temp[k][l];
                        }
                    }
                }

                for(int k = 0; k < width; k++) {
                    for(int l = 0; l < width; l++) {
                        map[k+startRow][l+startCol] = rotated[k][l];
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for(int j = 0; j < N; j++) {
                int sum = 0;
                for(int k = 0; k < N; k++) {
                    sum += map[j][k];
                }
                min = Math.min(min,  sum);
            }

            System.out.println("#" + i + " " + min);
        }
    }
}

// r = 회전 시작 행
// c = 회전 시작 열
// s = 회전 정사각형 길이
// D(R 시계, L 반시계) = 방향