import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt(); // 선택 횟수
            int P = sc.nextInt(); // 폭탄 층수

            long current = 0;
            for(int j = 1; j <= N; j++) {
                if(current+j == P) current += j-1;
                else current+= j;
            }

            System.out.println(current);
        }
    }
}