import java.util.*;
public class Main {
    static int max;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = scanner.nextInt();
        int n = scanner.nextInt();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = scanner.nextInt();
        }
        max = 0;
        divideBudget(budget, costs,0, 0);
        System.out.print(max);
    }
    public static void divideBudget(int n, int[] costs, int current, int start){
        if(current > n){
            return;
        }
        if(max < current){
            max = current;
        }
        if (start == costs.length) {
            return;
        }
        for(int i = start; i < costs.length; i++){
            divideBudget(n, costs, current + costs[i], i+1);
        }
    }
}
