import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            int[] customer = new int[N];
            for(int j = 0; j < N; j++){
                customer[j] = sc.nextInt();
            }

            Arrays.sort(customer);
            int remain = 0;
            int idx = 0;
            boolean isPossible = true;
            for(int time = 0; time <= customer[customer.length-1] && idx < customer.length; time++){
                if(time != 0 && time % M == 0) remain += K;
                if(time == customer[idx] && remain != 0) {
                    remain--;
                    idx++;
                }
                else if(time == customer[idx] && remain == 0){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) System.out.println("#" + i + " Possible");
            else System.out.println("#" + i + " Impossible");
        }
    }
}
