import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 1; i <= TC; i++) {
            int N = sc.nextInt();
            int[] count = new int[10];
            sc.nextLine();

            for(int j = 0; j < N; j++) {
                String[] arr = sc.nextLine().split(" ");

                if(arr[4].equals("YES")) {
                    for(int k = 0; k < 4; k++) {
                        count[Integer.parseInt(arr[k])]++;
                    }
                }
                else {
                    for(int k = 0; k < 4; k++) {
                        count[Integer.parseInt(arr[k])]--;
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            int idx = 0;
            for(int j = 0; j < 10; j++) {
                if(count[j] > max) {
                    max = count[j];
                    idx = j;
                }
            }

            System.out.println("#" + i + " " + idx);
        }
        sc.close();
    }
}