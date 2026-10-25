import java.util.*;

public class Solution{
    static int max;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            max = 0;
            int N = sc.nextInt(); // 재료 수
            int L = sc.nextInt(); // 제한 칼로리
            int[][] menu = new int[N][2];
            for(int j = 0; j < N; j++){
                menu[j][0] = sc.nextInt(); // 맛 점수
                menu[j][1] = sc.nextInt(); // 칼로리
            }
            dfs(menu, L, 0, 0, 0);
            System.out.println("#" + i + " " + max);
        }
    }
    static void dfs(int[][] menu, int L, int currentK, int currentT, int start){
        max = Math.max(max, currentT);
        for(int i = start; i < menu.length; i++){
            if(L >= currentK+menu[i][1]) {
                dfs(menu, L, currentK + menu[i][1],currentT + menu[i][0], i+1);
            }
        }
    }
}