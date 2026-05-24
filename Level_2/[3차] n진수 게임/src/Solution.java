import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder temp = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;
        while(num < t * m){
            temp.append(Integer.toString(num, n).toUpperCase());
            num++;
        }
        for(int i = 0; i < t; i++){
            int target = (p-1) + (i*m);
            answer.append(temp.charAt(target));
        }
        return answer.toString();
    }
}