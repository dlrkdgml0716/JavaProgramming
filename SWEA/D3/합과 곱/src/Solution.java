import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 1; i <= TC; i++){
            long S = sc.nextLong();
            long P = sc.nextLong();
            List<long[]> li = new ArrayList<>();

            if((S == 1 || P == 1) && S <= P) {
                System.out.println("No");
                continue;
            }
            else{
                for(long j = 1; j <= P / j; j++){
                    if(P%j == 0) li.add(new long[]{j, P/j});
                }
            }

            boolean isPossible = false;
            for(long[] num : li){
                if(num[0] + num[1] == S) {
                    isPossible = true;
                    break;
                }
            }
            if(isPossible) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}