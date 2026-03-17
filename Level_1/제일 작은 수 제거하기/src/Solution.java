import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> li = new ArrayList<>();
        if(arr.length == 1) return new int[]{-1};
        int min = 2000000000;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min) min = arr[i];
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != min) li.add(arr[i]);
        }
        return li.stream().mapToInt(Integer::intValue).toArray();
    }
}