<<<<<<< HEAD:Level_1/대충 만든 자판/src/Solution.java
import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(String key : keymap){
            for(int i = 0; i < key.length(); i ++){
                char keyC = key.charAt(i);
                int num = i + 1;
                if(!map.containsKey(keyC) || map.get(keyC) > num){
                    map.put(keyC, num);
                }
            }
        }

        for(int i = 0; i < targets.length; i++){
            String target = targets[i];
            int totalTouch = 0;
            boolean isPossible = true;

            for(int j = 0; j < target.length(); j++){
                char targetC = target.charAt(j);
                if(map.containsKey(targetC)){
                    totalTouch += map.get(targetC);
                }
                else{
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                answer[i] = totalTouch;
            } else {
                answer[i] = -1;
            }
        }
        return answer;
    }
=======
import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(String key : keymap){
            for(int i = 0; i < key.length(); i ++){
                char keyC = key.charAt(i);
                int num = i + 1;
                if(!map.containsKey(keyC) || map.get(keyC) > num){
                    map.put(keyC, num);
                }
            }
        }

        for(int i = 0; i < targets.length; i++){
            String target = targets[i];
            int totalTouch = 0;
            boolean isPossible = true;

            for(int j = 0; j < target.length(); j++){
                char targetC = target.charAt(j);
                if(map.containsKey(targetC)){
                    totalTouch += map.get(targetC);
                }
                else{
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                answer[i] = totalTouch;
            } else {
                answer[i] = -1;
            }
        }
        return answer;
    }
>>>>>>> 45d2e9c7b3816c2a15ebf931143520459f507bc8:programmers/Level_1/대충 만든 자판/src/Solution.java
}