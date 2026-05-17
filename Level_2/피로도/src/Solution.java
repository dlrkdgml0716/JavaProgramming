class Solution {
    int answer;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, 0);
        return answer;
    }
    private void dfs(int[][] dungeons, boolean[] visited, int k, int depth){
        answer = Math.max(answer, depth);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, visited, k - dungeons[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
}