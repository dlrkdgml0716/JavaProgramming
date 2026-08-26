import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] map = new int[m][n];
        int count = 1;
        for (int[] drop : drops) {
            if (map[drop[0]][drop[1]] != 0) continue;
            map[drop[0]][drop[1]] = count;
            count++;
        }

        int cols = n - w + 1;
        int[][] rowMin = new int[m][cols];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            dq.clear();
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    while (!dq.isEmpty() && map[i][dq.peekLast()] >= map[i][j]) dq.pollLast();
                    dq.addLast(j);
                }
                while (!dq.isEmpty() && dq.peekFirst() <= j - w) dq.pollFirst();
                if (j >= w - 1) rowMin[i][j - w + 1] = dq.isEmpty() ? 0 : map[i][dq.peekFirst()];
            }
        }

        int[][] winMin = new int[m - h + 1][cols];
        for (int i = 0; i < cols; i++) {
            dq.clear();
            for (int j = 0; j < m; j++) {
                if (rowMin[j][i] != 0) {
                    while (!dq.isEmpty() && rowMin[dq.peekLast()][i] >= rowMin[j][i]) dq.pollLast();
                    dq.addLast(j);
                }
                while (!dq.isEmpty() && dq.peekFirst() <= j - h) dq.pollFirst();
                if (j >= h - 1) winMin[j - h + 1][i] = dq.isEmpty() ? 0 : rowMin[dq.peekFirst()][i];
            }
        }

        int best = -1;
        int[] ans = new int[2];
        for (int j = 0; j < m - h + 1; j++) {
            for (int i = 0; i < cols; i++) {
                int val = (winMin[j][i] == 0) ? Integer.MAX_VALUE : winMin[j][i];
                if (val > best) { best = val; ans[0] = j; ans[1] = i; }
            }
        }
        return ans;
    }
}