import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] chArr = new char[s.length()];

        Arrays.fill(answer, -1);

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            chArr[i] = ch;
            for(int j = i - 1; j >= 0; j--){
                if(ch == chArr[j]){
                    answer[i] = i - j;
                    break;
                }
            }
        }
        return answer;
    }
}