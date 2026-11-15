import java.util.*;

public class Solution {
    static Set<Integer> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int[] num = new int[7];
            set = new HashSet<>();
            for(int j = 0; j < 7; j++) {
                num[j] = sc.nextInt();
            }


            solve(num, 0, 0, 0);

            List<Integer> li = new ArrayList<>(set);
            Collections.sort(li);
            Collections.reverse(li);

            System.out.println("#" + i + " " + li.get(4));
        }

        sc.close();
    }
    static void solve(int[] num, int sum, int count, int start) {
        if(count == 3) {
            set.add(sum);
            return;
        }
        for(int i = start; i < num.length; i++) {
            solve(num, sum + num[i], count + 1, i+1);
        }
    }
}