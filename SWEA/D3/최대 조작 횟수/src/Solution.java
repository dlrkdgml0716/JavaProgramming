import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            long A = sc.nextLong();
            long B = sc.nextLong();

            long diff = B - A;
            long count = 0;

            if(diff < 0 || diff == 1){
                System.out.println("#" + i + " -1");
                continue;
            }

            if(diff%2 == 1){
                diff -= 3;
                count++;
            }

            count += diff/2;
            System.out.println("#" + i + " " + count);
        }
    }
}