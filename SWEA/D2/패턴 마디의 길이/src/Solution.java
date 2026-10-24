import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            String s = sc.next();

            for (int len = 1; len <= s.length(); len++) {
                String str = s.substring(0, len);
                boolean valid = true;

                for (int j = len; j < s.length(); j += len) {
                    int end = Math.min(j + len, s.length());

                    String actual = s.substring(j, end);
                    String expected = str.substring(0, end - j);

                    if (!actual.equals(expected)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    System.out.println("#" + t + " " + len);
                    break;
                }
            }
        }
    }
}