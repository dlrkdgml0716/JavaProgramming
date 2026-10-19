import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] bugs = new int[N][N];
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(sc.nextLine());
                for(int k = 0; k < N; k++){
                    bugs[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for (int j = 0; j < N - (M-1); j++) {
                for (int k = 0; k < N - (M-1) ; k++) {
                    int sum = 0;
                    for (int dir = 0; dir < M; dir++) {
                        for (int dc = 0; dc < M; dc++) {
                            sum += bugs[j + dir][k + dc];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#" + (i+1) + " " + max);
        }
    }
}