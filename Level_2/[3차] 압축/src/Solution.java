import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> li = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(char c = 'A'; c <= 'Z'; c++){
            map.put(String.valueOf(c), c - 'A' + 1);
        }
        int idx = 0;
        int dicNum = 27;
        int n = msg.length();
        while(idx < n){
            int nextIdx = idx + 1;
            while(n >= nextIdx && map.containsKey(msg.substring(idx, nextIdx))){
                nextIdx++;
            }
            if (nextIdx <= n) {
                map.put(msg.substring(idx, nextIdx), dicNum++);
            }
            li.add(map.get(msg.substring(idx, nextIdx-1)));
            idx = nextIdx - 1;
        }
        return li.stream().mapToInt(i->i).toArray();
    }
}