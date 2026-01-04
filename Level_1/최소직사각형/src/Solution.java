import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int n = sizes.length;
        int[] col = new int[n];
        int[] row = new int[n];
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                row[i] = sizes[i][1];
                col[i] = sizes[i][0];
            }
            else{
                row[i] = sizes[i][0];
                col[i] = sizes[i][1];
            }
        }
        Arrays.sort(row);
        Arrays.sort(col);
        int answer = row[n-1] * col[n-1];
        return answer;
    }
}