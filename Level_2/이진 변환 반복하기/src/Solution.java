import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cycleCount = 0;
        int removedZeros = 0;

        while (!s.equals("1")) {
            int originalLength = s.length();
            int countOne = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    countOne++;
                }
            }
            removedZeros += (originalLength - countOne);
            s = Integer.toBinaryString(countOne);

            cycleCount++;
        }

        return new int[]{cycleCount, removedZeros};
    }
}