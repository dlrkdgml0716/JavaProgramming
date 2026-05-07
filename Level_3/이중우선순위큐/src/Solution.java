import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(command.equals("I")){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            else if(!map.isEmpty()){
                int target = (num == 1) ? map.lastKey():map.firstKey();
                int count = map.get(target);
                if (count == 1) {
                    map.remove(target);
                } else {
                    map.put(target, count - 1);
                }
            }
        }
        if (map.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{map.lastKey(), map.firstKey()};
    }
}