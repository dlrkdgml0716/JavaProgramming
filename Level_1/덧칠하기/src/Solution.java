import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 1;
        int first = section[0];
        int roller = m;

        for (int i = 1; i < section.length; i++) {
            if (m > section[i] - first) {
                continue;
            } else {
                first = section[i];
                count++;
            }
        }

        return count;
    }
}