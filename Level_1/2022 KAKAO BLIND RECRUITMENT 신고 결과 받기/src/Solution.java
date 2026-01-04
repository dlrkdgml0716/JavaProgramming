import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        int[][] records = new int[n][n];
        int[] block = new int[n];

        Map<String, Integer> idMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idMap.put(id_list[i], i);
        }

        for (String r : report) {
            String[] str = r.split(" ");
            int reporterIdx = idMap.get(str[0]);
            int reportedIdx = idMap.get(str[1]);

            if (records[reporterIdx][reportedIdx] == 0) {
                records[reporterIdx][reportedIdx] = 1;
                block[reportedIdx]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (records[i][j] == 1 && block[j] >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}