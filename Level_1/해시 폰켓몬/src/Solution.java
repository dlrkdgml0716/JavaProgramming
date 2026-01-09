import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int mSize = map.size();
        for(int i = 0; i < map.size(); i++){
            if(mSize > nums.length/2) mSize--;
            else break;
        }
        answer = mSize;
        return answer;
    }
}