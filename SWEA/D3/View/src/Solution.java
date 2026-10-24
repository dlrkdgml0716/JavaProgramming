import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 10; i++){
            int N = sc.nextInt();
            int[] li = new int[N];

            for(int j = 0; j < li.length; j++){
                li[j] = sc.nextInt();
            }
            int sum = 0;
            for(int j = 2; j < li.length - 2; j++){
                int one = Math.max(li[j-1], li[j+1]);
                int two = Math.max(li[j-2], li[j+2]);
                int view = li[j] - Math.max(one, two);

                if(view > 0) sum += view;
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}