import java.util.*;

class Solution {
    public String solution(String s) {
        String[] parts = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String part : parts) {
            int n = Integer.parseInt(part);
            if (n < min) min = n;
            if (n > max) max = n;
        }

        return min + " " + max;
    }
}