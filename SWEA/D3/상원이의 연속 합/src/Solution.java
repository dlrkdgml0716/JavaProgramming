import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt();

            int count = 1;
            for(int j = N-1; j >= 2; j--) {
                int sum = j;
                for(int k = j - 1; k >= 0; k--) {
                    if(sum == N) {
                        count++;
                        break;
                    }
                    else if(sum + k <= N) sum+= k;
                    else if(sum + k > N) break;
                }
            }

            System.out.println("#" + i + " " + count);
        }
    }
}