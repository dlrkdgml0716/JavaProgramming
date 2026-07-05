import java.util.*;
public class Main {
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        min = Integer.MAX_VALUE;
        solved(N, "", 0, false, false, false);
    }
    public static void solved(int N, String current, int depth, boolean state1, boolean state2, boolean state3){
        if(current.length() > 3){
            if(!check(current)) return;
        }
        if(depth == N){
            System.out.print(current);
            System.exit(0);
        }
        if (depth == 0) {
            solved(N, "1", 1, true, false, false);
            solved(N, "2", 1, false, true, false);
            solved(N, "3", 1, false, false, true);
            return;
        }
        if(state1){
            solved(N, current + 2, depth+1, false, true, false);
            solved(N, current + 3, depth+1, false, false, true);
        }
        if(state2){
            solved(N, current + 1, depth+1, true, false, false);
            solved(N, current + 3, depth+1, false, false, true);
        }
        if(state3){
            solved(N, current + 1, depth+1, true, false, false);
            solved(N, current + 2, depth+1, false, true, false);
        }
    }
    public static boolean check(String s) {
        int len = s.length();
        for (int i = 2; i <= len / 2; i++) {
            String back = s.substring(len - i, len);
            String front = s.substring(len - i * 2, len - i);
            if (front.equals(back)) {
                return false;
            }
        }
        return true;
    }
}