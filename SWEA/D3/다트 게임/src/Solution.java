import java.util.*;

public class Solution {
    static double[] score = {20, 40, 60, 80, 100, 120, 140, 160, 180, 200};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 1; i <= TC; i++){
            int N = sc.nextInt();

            int point = 0;
            for(int j = 0; j < N; j++){
                double x = sc.nextInt();
                double y = sc.nextInt();
                double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

                for(int k = 0; k < score.length; k++){
                    if(distance > score[k]) continue;
                    else if(distance <= score[k]) {
                        point += 10 - k;
                        break;
                    }
                }
            }
            System.out.println("#" + i + " " + point);
        }
    }
}