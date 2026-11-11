import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int i = 1; i <= TC; i++) {
            long N = sc.nextLong();
            int PD = sc.nextInt();
            int PG = sc.nextInt();

            boolean isPossible = false;

            if ((PG == 100 && PD != 100) || (PG == 0 && PD != 0)) {
                isPossible = false;
            } else {
                for (int j = 1; j <= Math.min(N, 100); j++) {
                    if ((j * PD) % 100 == 0) {
                        isPossible = true;
                        break;
                    }
                }
            }
            if (isPossible) {
                System.out.println("#" + i + " Possible");
            } else {
                System.out.println("#" + i + " Broken");
            }
        }
    }
}