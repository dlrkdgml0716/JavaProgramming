import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        int addIndex = 0;
        ArrayList<Integer> li = new ArrayList<Integer>();
        for(int i = 1; i < food.length; i++){
            int num = food[i];
            for(int j = 0; j < (num/2)*2; j++){
                li.add(addIndex, i);
            }
            addIndex += num/2;
        }
        li.add(addIndex, 0);
        for(int i = 0; i < li.size(); i++){
            answer += Integer.toString(li.get(i));
        }
        return answer;
    }
}