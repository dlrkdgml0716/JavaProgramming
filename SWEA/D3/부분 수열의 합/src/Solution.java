import java.util.*;

public class Solution{
    static int count;
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            count = 0;
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] num = new int[N];
            for(int j = 0; j < N; j++){
                num[j] = sc.nextInt();
            }

            dfs(num, K, 0, 0);
            System.out.println("#" + i + " " + count);
        }
    }
    static void dfs(int[] num, int K, int start, int current){
        if(current > K) return;
        if(current == K){
            count++;
            return;
        }
        for(int i = start; i < num.length; i++){
            dfs(num, K, i+1, current + num[i]);
        }
    }
}