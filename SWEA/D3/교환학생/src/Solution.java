import java.util.*;

public class Solution{
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 1; i <= TC; i++) {
            min = Integer.MAX_VALUE;
            int N = sc.nextInt(); // 일 수
            int[] lecture = new int[7];

            for(int j = 0; j < 7; j++) {
                lecture[j] = sc.nextInt();
            }

            for(int j = 0; j < 7; j++) {
                if(lecture[j] == 1) solve(lecture, j, N, 0, 0);
            }

            System.out.println("#" + i + " " + min);
        }

        sc.close();
    }
    static void solve(int[] lecture, int start, int N, int stay, int count) {
        while(count != N) {
            if(lecture[start%7] == 1) count++;
            stay++;
            start++;
        }
        if(min <= stay) return;
        if(count == N) {
            min = Math.min(min, stay);
            return;
        }
    }
}