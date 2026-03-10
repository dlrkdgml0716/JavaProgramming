class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        for (int t = 1; t <= 3200000; t++) {
            boolean allYellow = true;
            for (int i = 0; i < n; i++) {
                int G = signals[i][0];
                int Y = signals[i][1];
                int R = signals[i][2];

                int totalCycle = G + Y + R;
                int currentTime = (t - 1) % totalCycle;
                if (currentTime < G || currentTime >= G + Y) {
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) return t;
        }
        return -1;
    }
}

// 일정 주기가 반복되는 문제는 나머지 연산(%)을 사용하면 성능 최적화 가능
// 모든 사이클은 각 구성요소간의 최소공배수를 넘을 경우 사이클 초기화 또는 최대가짓수를 넘을 경우 모든 경우 체크