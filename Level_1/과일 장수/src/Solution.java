import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] AppleBox = new int[score.length/m];

        Arrays.sort(score);
        int box = 1;

        for(int i = score.length; i > 0; i-=m){
            int minPrice = k;
            if(box <= AppleBox.length){
                for(int j = i-1; j >= i-m; j--){
                    if(minPrice > score[j]){
                        minPrice = score[j];
                    }
                }
                AppleBox[box-1] = minPrice;
                box++;
            }
            else{
                break;
            }
        }

        for(int i = 0; i < AppleBox.length; i++){
            answer += AppleBox[i] * m;
        }
        return answer;
    }
}