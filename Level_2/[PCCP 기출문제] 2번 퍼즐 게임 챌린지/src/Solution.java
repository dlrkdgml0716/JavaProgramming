class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int low = 1;
        int high = 100000;
        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(diffs, times, limit, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
    private boolean isPossible(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int timeCur = times[i];
            if (diff <= level) {
                totalTime += timeCur;
            } else {
                int timePrev = (i == 0) ? 0 : times[i - 1];
                long numFail = diff - level;
                totalTime += (long)(timeCur + timePrev) * numFail + timeCur;
            }
            if (totalTime > limit) {
                return false;
            }
        }

        return totalTime <= limit;
    }
}