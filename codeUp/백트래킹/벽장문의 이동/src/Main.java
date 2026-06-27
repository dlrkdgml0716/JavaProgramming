import java.util.*;
public class Main {
    static int min;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cabinet = scanner.nextInt();
        int[] open = new int[2];
        for(int i = 0; i < 2; i++) open[i] = scanner.nextInt();

        int sequence = scanner.nextInt();
        int[] order = new int[sequence];
        for(int i = 0; i < sequence; i++) order[i] = scanner.nextInt();

        min = Integer.MAX_VALUE;
        findMinCase(open, order, 0, 0);
        System.out.print(min);
    }
    public static void findMinCase(int[] open, int[] order, int dept, int count){
        if (count >= min) return;
        if (dept == order.length){
            if(min > count) min = count;
            return;
        }
        int target = order[dept];

        int originA = open[0];
        int distA = Math.abs(originA - target);

        open[0] = target;
        findMinCase(open, order, dept + 1, count + distA);
        open[0] = originA;

        int originB = open[1];
        int distB = Math.abs(originB - target);

        open[1] = target;
        findMinCase(open, order, dept + 1, count + distB);
        open[1] = originB;
    }
}
