import java.util.*;
class Solution {
    HashMap<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(int i = 0; i < info.length; i++){
            String[] p = info[i].split(" ");
            makeCombination(p, "", 0);
        }

        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        for(int i = 0; i < query.length; i++){
            String s = query[i].replace(" and ", " ");
            String[] q = s.split(" ");

            String str = q[0] + q[1] + q[2] + q[3];
            int targetScore = Integer.parseInt(q[4]);

            if(map.containsKey(str)){
                answer[i] = binarySearch(map.get(str), targetScore);
            }
            else answer[i] = 0;
        }
        return answer;
    }
    public void makeCombination(String[] p, String current, int depth){
        if(depth == 4){
            if(!map.containsKey(current)) map.put(current, new ArrayList<>());
            map.get(current).add(Integer.parseInt(p[4]));
            return;
        }
        makeCombination(p, current+p[depth], depth+1);
        makeCombination(p, current+"-", depth+1);
    }
    public int binarySearch(List<Integer> list, int target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid) >= target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.size() - left;
    }
}