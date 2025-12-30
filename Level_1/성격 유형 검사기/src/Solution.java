import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chrs = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char c : chrs) {
            map.put(c, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            int score = choices[i];
            if (score < 4) {
                char ch = survey[i].charAt(0);
                map.put(ch, map.get(ch) + (4 - score));
            } else if (score > 4) {
                char ch = survey[i].charAt(1);
                map.put(ch, map.get(ch) + (score - 4));
            }
        }
        answer.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        answer.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        answer.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        answer.append(map.get('A') >= map.get('N') ? 'A' : 'N');

        return answer.toString();
    }
}