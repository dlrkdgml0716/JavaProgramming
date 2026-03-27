import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> baseMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            baseMap.put(want[i], number[i]);
        }
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> tempMap = new HashMap<>(baseMap);
            for (int j = i; j < i + 10; j++) {
                String item = discount[j];
                if (tempMap.containsKey(item)) {
                    tempMap.put(item, tempMap.get(item) - 1);
                }
            }
            if (isGoalMet(tempMap)) {
                answer++;
            }
        }
        return answer;
    }
    private boolean isGoalMet(Map<String, Integer> map) {
        for (int count : map.values()) {
            if (count > 0) return false;
        }
        return true;
    }
}