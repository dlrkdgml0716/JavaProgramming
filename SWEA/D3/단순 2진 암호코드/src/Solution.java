import java.util.*;

public class Solution {
    static int[][] password = {
            {3, 2, 1, 1},
            {2, 2, 2, 1},
            {2, 1, 2, 2},
            {1, 4, 1, 1},
            {1, 1, 3, 2},
            {1, 2, 3, 1},
            {1, 1, 1, 4},
            {1, 3, 1, 2},
            {1, 2, 1, 3},
            {3, 1, 1, 2}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int col = sc.nextInt();
            int row = sc.nextInt();
            int[][] map = new int[col][row];
            for (int j = 0; j < col; j++) {
                String s = sc.next();
                for (int k = 0; k < row; k++) {
                    map[j][k] = s.charAt(k) - '0';
                }
            }
            int startCol = 0;
            int startRow = 0;
            boolean found = false;
            for (int j = 0; j < col && !found; j++) {
                for (int k = row - 1; k >= 0; k--) {
                    if (map[j][k] == 1) {
                        startCol = j;
                        startRow = k;
                        found = true;
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < 56; j++) {
                sb.insert(0, map[startCol][startRow - j]);

                if (j % 7 == 6) {
                    result.insert(0, transform(sb.toString()));
                    sb = new StringBuilder();
                }
            }
            int odd = 0;
            int even = 0;
            String resultS = result.toString();
            for (int j = 0; j < resultS.length(); j++) {
                if ((j + 1) % 2 != 0) {
                    odd += resultS.charAt(j) - '0';
                } else {
                    even += resultS.charAt(j) - '0';
                }
            }
            if ((odd * 3 + even) % 10 == 0) {
                System.out.println("#" + i + " " + (odd + even));
            } else {
                System.out.println("#" + i + " 0");
            }
        }
    }
    static int transform(String s) {
        int[] count = {1, 0, 0, 0};
        int idx = 0;
        char start = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (start == s.charAt(i)) {
                count[idx]++;
            } else {
                idx++;
                start = s.charAt(i);
                count[idx]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (Arrays.equals(count, password[i])) {
                return i;
            }
        }
        return 0;
    }
}