import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt(); // 반지름
            int count = 0;

            for(int j = -N; j <= N; j++) {
                for(int k = -N; k <= N; k++) {
                    if(Math.pow(j, 2) + Math.pow(k, 2) <= Math.pow(N, 2)) {
                        count++;
                    }
                }
            }

            System.out.println("#" + i + " " + count);
        }
    }
}