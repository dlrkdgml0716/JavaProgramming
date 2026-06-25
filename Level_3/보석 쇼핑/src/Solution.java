import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int kindCount = gemTypes.size();
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (end < gems.length) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            while (map.size() == kindCount) {
                if (end - start < minLen) {
                    minLen = end - start;
                    result[0] = start + 1;
                    result[1] = end + 1;
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }
            end++;
        }

        return result;
    }
}