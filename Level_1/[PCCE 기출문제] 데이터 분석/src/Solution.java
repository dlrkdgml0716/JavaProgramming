import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] columns = {"code", "date", "maximum", "remain"};
        int extIdx = 0, sortIdx = 0;
        for(int i=0; i<4; i++) {
            if(columns[i].equals(ext)) extIdx = i;
            if(columns[i].equals(sort_by)) sortIdx = i;
        }

        List<int[]> list = new ArrayList<>();
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                list.add(row);
            }
        }

        final int finalSortIdx = sortIdx;
        Collections.sort(list, (o1, o2) -> o1[finalSortIdx] - o2[finalSortIdx]);

        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}