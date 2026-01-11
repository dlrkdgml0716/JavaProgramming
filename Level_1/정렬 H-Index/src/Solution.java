import java.util.Arrays;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m]; //
        int INF = 1000000; // 최솟값을 찾기위한 적당한 큰수
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] item : info) {
            int aTrace = item[0];
            int bTrace = item[1];

            int[] nextDp = new int[m];
            Arrays.fill(nextDp, INF);

            for (int j = 0; j < m; j++) {
                if (dp[j] == INF) continue;
                if (dp[j] + aTrace < n) {
                    nextDp[j] = Math.min(nextDp[j], dp[j] + aTrace);
                }
                if (j + bTrace < m) {
                    nextDp[j + bTrace] = Math.min(nextDp[j + bTrace], dp[j]);
                }
            }
            dp = nextDp;
        }
        int answer = INF;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[i]);
        }
        return (answer == INF) ? -1 : answer;
    }
}

// 못풀었음