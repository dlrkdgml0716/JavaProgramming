import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int current_weight = 0;
        int index = 0;
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (index < truck_weights.length) {
            time++;
            current_weight -= bridge.poll();

            int nextTruck = truck_weights[index];

            if (current_weight + nextTruck <= weight) {
                bridge.add(nextTruck);
                current_weight += nextTruck;
                index++;
            } else {
                bridge.add(0);
            }
        }
        return time + bridge_length;
    }
}