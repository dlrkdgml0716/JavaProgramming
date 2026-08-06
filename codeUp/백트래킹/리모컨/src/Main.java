import java.util.*;
public class Main{
    static int now;
    static int target;
    static int min;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(s);
        now = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        min = Math.abs(target - now);
        int[] control = {1, -1, 5, -5, 10, -10};
        solved(control, now,0);

        System.out.print(min);
    }
    static void solved(int[] control, int current, int count){
        if(current < 0 || current > 40){
            return;
        }
        if(current == target){
            min = Math.min(min, count);
            return;
        }
        if(count + Math.abs(target - current)/10 >= min) return;
        for(int i = 0; i < control.length; i++){
            solved(control, current + control[i], count + 1);
        }
    }
}