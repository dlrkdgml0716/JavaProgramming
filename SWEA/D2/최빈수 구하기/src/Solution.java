import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i = 0; i < testCase; i++){
            int[] score = new int[101];
            int num =  sc.nextInt();
            for(int j = 0; j < 1000; j++){
                score[sc.nextInt()] += 1;
            }
            int max = 0;
            int maxIdx = -1;
            for(int j = 0; j < score.length; j++){
                if(score[j] == 0) continue;
                if(max <= score[j] && maxIdx < j){
                    max = score[j];
                    maxIdx = j;
                }
            }
            System.out.println("#" + num + " " + maxIdx);
        }
    }
}