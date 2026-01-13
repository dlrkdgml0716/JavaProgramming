import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                if(!li.contains(numbers[i]+numbers[j])){
                    li.add(numbers[i]+numbers[j]);
                }
            }
        }
        Collections.sort(li);
        int[] answer = new int[li.size()];
        for(int i = 0; i < li.size(); i++){
            answer[i] = li.get(i);
        }
        return answer;
    }
}