import java.util.*;

public class Solution {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] Ai = new int[N];
            int[] Bj = new int[M];

            for(int j = 0; j < N; j++){
                Ai[j] = sc.nextInt();
            }
            for(int j = 0; j < M; j++){
                Bj[j] = sc.nextInt();
            }
            int last = 0;
            if(Ai.length < Bj.length){
                last = Ai.length;
            }
            else last = Bj.length;
            dfs(Ai, Bj, 0, last);
            System.out.println("#" + (i+1) + " " + max);
            max = 0;
        }
    }
    static void dfs(int[] Ai, int[] Bj, int depth, int last){
        if(depth == Math.abs(Ai.length - Bj.length) + 1){
            return;
        }

        int current = 0;
        if(Ai.length < Bj.length){
            for(int i = 0; i < last; i++){
                current += Ai[i] * Bj[i+depth];
            }
        }
        else{
            for(int i = 0; i < last; i++){
                current += Ai[i+depth] * Bj[i];
            }
        }
        max = (int)Math.max(max, current);
        dfs(Ai, Bj, depth + 1, last);
    }
}