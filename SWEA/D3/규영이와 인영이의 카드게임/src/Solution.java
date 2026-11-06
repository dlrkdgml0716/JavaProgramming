import java.util.*;

public class Solution {
    static int[] in = new int[9];
    static int[] gyu = new int[9];
    static int win;
    static int lose;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++){
            win = 0;
            lose = 0;
            boolean[] check = new boolean[19];
            for(int j = 0; j < 9; j++){
                gyu[j] = sc.nextInt();
                check[gyu[j]] = true;
            }

            int idx = 0;
            for(int j = 1; j <= 18; j++){
                if(!check[j]){
                    in[idx++] = j;
                }
            }

            boolean[] visited = new boolean[9];
            dfs(0, 0, 0, visited);
            System.out.println("#" + i + " " + win + " " + lose);
        }
    }
    static void dfs(int depth, int inScore, int gyuScore, boolean[] visited){
        if(depth == 9){
            if(inScore < gyuScore) win++;
            else lose++;
            return;
        }
        for(int i = 0; i < 9; i++){
            if(visited[i]) continue;
            else{
                visited[i] = true;
                if(in[i] > gyu[depth]){
                    visited[i] = true;
                    dfs(depth + 1, inScore + in[i] + gyu[depth], gyuScore, visited);
                    visited[i] = false;
                }
                else{
                    visited[i] = true;
                    dfs(depth + 1, inScore, gyuScore + in[i] + gyu[depth], visited);
                    visited[i] = false;
                }
            }
        }
    }
}