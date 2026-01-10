import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        if(map.size() == 1){
            answer = clothes.length;
        }
        else {
            int temp = 1;
            for (int count : map.values()) {
                temp *= (count + 1);
            }
            answer = temp - 1;
        }
        return answer;
    }
}