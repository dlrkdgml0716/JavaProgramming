import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt(); // 상자 개수
            int Q = sc.nextInt(); // 변경 횟수

            int[] box = new int[N+1];
            int num = 0;
            for(int j = 0; j < Q; j++) {
                num++;
                int L = sc.nextInt();
                int R = sc.nextInt();

                for(int start = L; start <= R; start++) {
                    box[start] = num;
                }
            }

            System.out.print("#"+ i);
            for(int j = 1; j < box.length; j++) {
                System.out.print(" " + box[j]);
            }
            System.out.println();
        }
    }
}