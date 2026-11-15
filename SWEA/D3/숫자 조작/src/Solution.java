import java.util.*;

public class Solution{
    static int max;
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= T; i++) {
            String s = sc.nextLine();
            if(s.length() == 1) {
                System.out.println("#" + i + " " + s + " " + s);
                continue;
            }
            min = Integer.parseInt(s);
            max = Integer.parseInt(s);

            int[] num = new int[s.length()];
            for(int j = 0; j < s.length(); j++) {
                num[j] = s.charAt(j) - '0';
            }

            solve(num);
            System.out.println("#" + i + " " + min + " " + max);
        }
    }
    static void solve(int[] num) {
        for(int i = 0; i < num.length - 1; i++) {
            for(int j = i+1; j < num.length; j++) {
                int[] copy = num.clone();
                int temp = copy[i];
                copy[i] = copy[j];
                copy[j] = temp;

                if(copy[0] == 0) continue;
                max = Math.max(max, changeInt(copy));
                min = Math.min(min, changeInt(copy));
            }
        }
    }
    static int changeInt(int[] copy) {
        int n = copy[copy.length -1];
        int e = 10;
        for(int i = copy.length - 2; i >= 0; i--) {
            n += copy[i] * e;
            e *= 10;
        }
        return n;
    }
}