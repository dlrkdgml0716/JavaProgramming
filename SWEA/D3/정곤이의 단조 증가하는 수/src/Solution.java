import java.util.*;

public class Solution{
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 1; i <= TC; i++) {
            max = -1;
            int N = sc.nextInt();

            int[] num = new int[N];
            for(int j = 0; j < N; j++){
                num[j] = sc.nextInt();
            }
            solve(num);

            if(max != -1) System.out.println("#" + i + " " + max);
            else System.out.println("#" + i + " " + -1);
        }

        sc.close();
    }
    static void solve(int[] num) {
        for(int i = 0; i < num.length - 1; i++) {
            for(int j = i+1; j < num.length; j++) {
                int target = num[i] * num[j];
                if(check(target)) max = Math.max(max,  target);
            }
        }
    }
    static boolean check(int target) {
        String s = String.valueOf(target);
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i)-'0' > s.charAt(i+1)-'0') return false;
        }
        return true;
    }
}