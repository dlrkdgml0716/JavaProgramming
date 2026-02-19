import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : priorities) {
            pq.add(p);
        }

        int count = 0;
        while (true) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    count++;
                    pq.poll();
                    if (i == location) {
                        return count;
                    }
                }
            }
        }
    }
}