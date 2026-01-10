import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            List<Integer> li = new ArrayList<>();
            int start = commands[i][0];
            int end = commands[i][1];
            int choice = commands[i][2];
            for(int j = start-1; j < end; j++){
                li.add(array[j]);
            }
            Collections.sort(li);
            answer[i] = li.get(choice-1);
        }
        return answer;
    }
}