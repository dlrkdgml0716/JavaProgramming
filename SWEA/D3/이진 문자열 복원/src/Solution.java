import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int[] binary = new int[4];

            for (int j = 0; j < 4; j++) {
                binary[j] = sc.nextInt();
            }

            int a = binary[0];
            int b = binary[1];
            int c = binary[2];
            int d = binary[3];

            StringBuilder sb = new StringBuilder();
            boolean isPossible = true;
            if (Math.abs(b - c) > 1) {
                isPossible = false;
            }
            else if (b == 0 && c == 0) {
                if (a > 0 && d > 0) {
                    isPossible = false;
                }
                else if (a > 0) {
                    for (int j = 0; j <= a; j++) {
                        sb.append('0');
                    }
                }
                else if (d > 0) {
                    for (int j = 0; j <= d; j++) {
                        sb.append('1');
                    }
                }
                else {
                    sb.append('0');
                }
            }
            else {
                char current = (b >= c) ? '0' : '1';
                sb.append(current);

                while (b > 0 || c > 0 || a > 0 || d > 0) {

                    if (current == '0') {
                        while (a > 0) {
                            sb.append('0');
                            a--;
                        }

                        if (b > 0) {
                            sb.append('1');
                            b--;
                            current = '1';
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        while (d > 0) {
                            sb.append('1');
                            d--;
                        }
                        if (c > 0) {
                            sb.append('0');
                            c--;
                            current = '0';
                        }
                        else {
                            break;
                        }
                    }
                }
                if (a != 0 || b != 0 || c != 0 || d != 0) {
                    isPossible = false;
                }
            }

            if (isPossible) {
                System.out.println("#" + i + " " + sb);
            }
            else {
                System.out.println("#" + i + " impossible");
            }
        }

        sc.close();
    }
}