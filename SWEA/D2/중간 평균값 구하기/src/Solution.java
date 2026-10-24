import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            int[] num = new int[10];
            for(int j = 0; j < 10; j++){
                num[j] = sc.nextInt();
            }
            Arrays.sort(num);
            int sum = 0;
            for(int j = 1; j < 9; j++){
                sum += num[j];
            }
            int remain = sum%8;
            if(remain*10 >= 8*5) System.out.println("#" + i + " " + (sum/8+1));
            else System.out.println("#" + i + " " + sum/8);
        }
    }
}