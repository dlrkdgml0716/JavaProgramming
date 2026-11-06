import java.util.*;

public class Solution {
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 1; i <= TC; i++){
            max = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] weight = new int[N];

            for(int j = 0; j < N; j++){
                weight[j] = sc.nextInt();
            }
            boolean[] visited = new boolean[weight.length];
            dfs(weight, 0, M, 0, visited);
            if(max == 0) System.out.println("#" + i + " " + -1);
            else System.out.println("#" + i + " " + max);
        }
    }
    static void dfs(int[] weight, int total, int M, int count, boolean[] visited){
        if(count == 2){
            if(total <= M) max = Math.max(max, total);
            return;
        }
        for(int i = 0; i < weight.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(weight, total + weight[i], M, count + 1, visited);
                visited[i] = false;
            }
        }
    }
}