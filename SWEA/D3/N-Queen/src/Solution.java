import java.util.*;

public class Solution{
    static int count;
    static boolean[] col;
    static boolean[] diagonal1;
    static boolean[] diagonal2;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1 ; i <= T; i++){
            int N = sc.nextInt();
            count = 0;
            col = new boolean[N];
            diagonal1 = new boolean[N * 2 -1];
            diagonal2 = new boolean[N * 2 -1];
            dfs(N, 0);
            System.out.println("#" + i + " " + count);
        }
    }
    static void dfs(int N, int row){
        if(N == row){
            count++;
            return;
        }
        for(int i = 0; i < N; i++){
            int d1 = row + i;
            int d2 = row - i + N - 1;
            if(col[i] || diagonal1[d1] || diagonal2[d2]){
                continue;
            }
            col[i] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;
            dfs(N, row+1);
            col[i] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }
}