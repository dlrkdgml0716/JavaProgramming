import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 1; i <= TC; i++){
            int N = sc.nextInt(); // 참가자 수
            int T = sc.nextInt(); // 문제 수
            int P = sc.nextInt(); // 지학이 번호

            int[][] problems = new int[N][T];
            int[] count = new int[N];
            for(int j = 0; j < N; j++){
                for(int k = 0; k < T; k++){
                    problems[j][k] = sc.nextInt();
                    if(problems[j][k] == 1) count[j]++;
                }
            }

            int[] problemScore = new int[T];
            for(int j = 0; j < N; j++){
                for(int k = 0; k < T; k++){
                    if(problems[j][k] == 0) problemScore[k]++;
                }
            }

            int[] score = new int[N];
            for(int j = 0; j < N; j++){
                for(int k = 0; k < T; k++){
                    if(problems[j][k] == 1) score[j] += problemScore[k];
                }
            }

            int moreScore = 0;
            int moreSolved = 0;
            int preNum = 0;
            for(int j = 0; j < N; j++){
                if(j == P-1) continue;

                if(score[P-1] < score[j]) moreScore++;
                else if(score[P-1] == score[j] && count[P-1] < count[j]) moreSolved++;
                else if(score[P-1] == score[j] && count[P-1] == count[j] && P-1 > j) preNum++;
            }

            System.out.println("#" + i + " " + score[P-1] + " " + (moreScore+moreSolved+preNum+1));
        }
    }
}