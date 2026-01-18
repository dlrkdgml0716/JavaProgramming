class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] activeServers = new int[24];

        for (int i = 0; i < 24; i++) {
            int required = players[i] / m;

            int current = activeServers[i];

            if (current < required) {
                int diff = required - current;
                answer += diff;

                for (int t = 0; t < k; t++) {
                    if (i + t < 24) {
                        activeServers[i + t] += diff;
                    }
                }
            }
        }

        return answer;
    }
}