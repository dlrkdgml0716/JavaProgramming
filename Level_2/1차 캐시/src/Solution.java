import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        int time = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 1; i <= cities.length; i++){
            if(map.containsKey(cities[i-1].toLowerCase())){
                map.put(cities[i-1].toLowerCase(), i);
                time++;
            }
            else if(map.size() < cacheSize){
                map.put(cities[i-1].toLowerCase(), i);
                time += 5;
            }
            else if(map.size() >= cacheSize){
                int low = cities.length;
                String where = "";
                for(String s : map.keySet()){
                    if(map.get(s) < low){
                        low = map.get(s);
                        where = s;
                    }
                }
                map.remove(where);
                map.put(cities[i-1].toLowerCase(), i);
                time += 5;
            }
        }
        return time;
    }
}