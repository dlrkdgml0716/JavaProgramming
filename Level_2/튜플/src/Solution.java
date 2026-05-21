import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        String cleanStr = s.replaceAll("[^0-9]+", " ").trim();
        String[] arr = cleanStr.split(" ");
        for(int i = 0; i < arr.length; i++){
            map.put(Integer.parseInt(arr[i]), map.getOrDefault(Integer.parseInt(arr[i]), 0)+1);
        }
        List<int[]> li = new ArrayList<>();
        for(int i : map.keySet()){
            li.add(new int[]{i, map.get(i)});
        }
        Collections.sort(li, (a, b) -> b[1] - a[1]);
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < li.size(); i++){
            answer.add(li.get(i)[0]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}