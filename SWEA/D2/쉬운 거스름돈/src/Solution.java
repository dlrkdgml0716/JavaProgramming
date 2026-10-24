import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] cost = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        for(int i = 1; i <= T; i++){
            int price = sc.nextInt();
            int idx = 0;
            int[] count = new int[cost.length];
            while(price >= 10){
                if(price >= cost[idx]){
                    count[idx] = price / cost[idx];
                    price %= cost[idx];
                }
                idx++;
            }
            System.out.println("#" + i);
            for(int j = 0; j < count.length; j++){
                System.out.print(count[j] + " ");
            }
            System.out.println();
        }
    }
}