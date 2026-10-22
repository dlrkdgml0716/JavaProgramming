import java.util.*;

public class Solution {
    static String[] rank = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] score = new int[N][3];
            for(int j = 0; j < N; j++){
                for(int k = 0; k < 3; k++){
                    score[j][k] = sc.nextInt();
                }
            }

            Double[] point = new Double[N];
            for(int j = 0; j < N; j++){
                double mid = score[j][0] * 0.35;
                double last = score[j][1] * 0.45;
                double task = score[j][2] * 0.2;
                double total = mid + last + task;
                point[j] = total;
            }

            double target = point[K-1];
            int grade = N/10;
            Arrays.sort(point, Comparator.reverseOrder());

            int target_num = 0;
            for(int j = 0; j < point.length; j++){
                if(target == point[j]){
                    target_num = j+1;
                    break;
                }
            }
            if(target_num % grade == 0){
                System.out.println("#" + (i+1) + " " + rank[(target_num/grade) - 1]);
            }
            else{
                System.out.println("#" + (i+1) + " " + rank[target_num/grade]);
            }
        }
    }
}