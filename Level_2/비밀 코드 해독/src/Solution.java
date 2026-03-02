import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        int[] combination = new int[5];
        for (int i = 1; i <= n - 4; i++) {
            for (int j = i + 1; j <= n - 3; j++) {
                for (int k = j + 1; k <= n - 2; k++) {
                    for (int l = k + 1; l <= n - 1; l++) {
                        for (int m_idx = l + 1; m_idx <= n; m_idx++) {
                            combination[0] = i;
                            combination[1] = j;
                            combination[2] = k;
                            combination[3] = l;
                            combination[4] = m_idx;
                            if (isValid(combination, q, ans)) {
                                answer++;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
    private boolean isValid(int[] comb, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int count = 0;
            for (int num : q[i]) {
                if (contains(comb, num)) {
                    count++;
                }
            }
            if (count != ans[i]) {
                return false;
            }
        }
        return true;
    }
    private boolean contains(int[] arr, int target) {
        for (int val : arr) {
            if (val == target) return true;
        }
        return false;
    }
}