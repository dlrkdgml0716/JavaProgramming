import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean visited[][] = new boolean[n][m];
        visited[0][0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        int answer = 0;
        while(!queue.isEmpty()){
            int current[] = queue.poll();
            if(current[0] == n -1 && current[1] == m-1){
                return current[2];
            }
            for(int i = 0; i < 4; i++){
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];

                if(x >= 0 && x < n && y >= 0 && y < m){
                    if(maps[x][y] == 1 && !visited[x][y]){
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y, current[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
}