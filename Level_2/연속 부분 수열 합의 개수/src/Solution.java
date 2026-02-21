import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;

        int[] doubled = new int[n * 2];
        for (int i = 0; i < n; i++) {
            doubled[i] = elements[i];
            doubled[i + n] = elements[i];
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += doubled[i + j];
                set.add(sum);
            }
        }
        return set.size();
    }
}