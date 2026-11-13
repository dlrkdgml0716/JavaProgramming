import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= T; i++) {
            String P = sc.nextLine();
            String Q = sc.nextLine();

            if(Q.length() - P.length() >= 2) {
                System.out.println("#" + i + " Y");
                continue;
            }
            else if(P.equals(Q)) {
                System.out.println("#" + i + " N");
                continue;
            }

            char[] arrP = new char[P.length()];
            char[] arrQ = new char[Q.length()];
            for(int j = 0; j < P.length(); j++) {
                arrP[j] = P.charAt(j);
            }
            for(int j = 0; j < Q.length(); j++) {
                arrQ[j] = Q.charAt(j);
            }

            boolean isPossible = false;
            for(int j = 0; j < P.length(); j++) {
                if(arrP[j] < arrQ[j]) {
                    isPossible = true;
                    break;
                }
            }

            if(isPossible) System.out.println("#" + i + " Y");
            else if(arrQ[P.length()] == 'a')System.out.println("#" + i + " N");
            else System.out.println("#" + i + " Y");
        }
    }
}