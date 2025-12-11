import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int score[] = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        String person;
        for(int i = 0; i < photo.length; i++){
            for(int j = 0; j < photo[i].length; j++){
                person = photo[i][j];
                if(map.containsKey(person)){
                    score[i] += map.get(person);
                }

            }
        }

        return score;
    }
}