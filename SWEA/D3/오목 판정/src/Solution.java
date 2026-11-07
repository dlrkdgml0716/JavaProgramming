import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            int N = sc.nextInt();
            sc.nextLine();
            char[][] map = new char[N][N];

            for(int j = 0; j < N; j++){
                String s = sc.nextLine();
                for(int k = 0; k < N; k++){
                    map[j][k] = s.charAt(k);
                }
            }

            boolean isPossible = false;
            for(int j = 0; j < N; j++){
                int countRow = 0;
                int countCol = 0;
                for(int k = 0; k < N; k++){
                    if(map[j][k] == 'o') countRow++;
                    else countRow = 0;
                    if(map[k][j] == 'o') countCol++;
                    else countCol = 0;
                    if(countRow >= 5 || countCol >= 5){
                        isPossible = true;
                        break;
                    }
                }
                if(isPossible) break;
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int LCross = 0;
                    int RCross = 0;

                    for (int m = 0; m < 5; m++) {
                        if (j + m < N && k + m < N) {
                            if (map[j + m][k + m] == 'o') LCross++;
                        }
                        if (j + m < N && k - m >= 0) {
                            if (map[j + m][k - m] == 'o') RCross++;
                        }
                    }
                    if (LCross == 5 || RCross == 5) {
                        isPossible = true;
                        break;
                    }
                }
                if (isPossible) break;
            }

            if(isPossible) System.out.println("#" + i + " YES");
            else System.out.println("#" + i + " NO");
        }
    }
}