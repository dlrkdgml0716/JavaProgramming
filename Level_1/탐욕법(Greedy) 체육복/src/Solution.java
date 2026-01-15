import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] std = new int[n];
        Arrays.fill(std, 1);
        for(int l : lost) std[l-1]--;
        for(int r : reserve) std[r-1]++;
        for(int i = 0; i < n; i++){
            if(std[i] == 0 ){
                if(i - 1 >= 0 && std[i - 1] == 2){
                    answer++;
                    std[i - 1]--;
                }
                else if(i + 1 < n && std[i + 1] == 2){
                    answer++;
                    std[i + 1]--;
                }
            }
        }
        for(int suit : std) {
            if(suit >= 1) answer++;
        }
        return answer;
    }
}