import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++) {
            int day = sc.nextInt();
            int[] cost = new int[day];

            for (int j = 0; j < day; j++) {
                cost[j] = sc.nextInt();
            }
            int max = cost[day - 1];
            int count = 0;
            long buy = 0;
            long result = 0;
            for (int j = day - 2; j >= 0; j--) {
                if(max > cost[j]){
                    count++;
                    buy += cost[j];
                }
                else if(max == cost[j]) continue;
                else{
                    result += (long)count * max - buy;
                    max = cost[j];
                    buy = 0;
                    count = 0;
                }
            }
            result += (long)count * max - buy;
            System.out.println("#" + (i+1) + " " + result);
            result = 0;
        }
        return;
    }
}