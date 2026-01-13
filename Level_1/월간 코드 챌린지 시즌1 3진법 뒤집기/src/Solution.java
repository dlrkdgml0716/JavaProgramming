import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> li = new ArrayList<>();
        while (n > 0) {
            li.add(n % 3);
            n /= 3;
        }
        int index = 0;
        for (int i = li.size() - 1; i >= 0; i--) {
            answer += li.get(i) * Math.pow(3, index);
            index++;
        }
        return answer;
    }
}