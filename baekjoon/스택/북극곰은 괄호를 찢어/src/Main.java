import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String s = scanner.next();

        int open = 0;
        int close = 0;

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '(') open++;
            else close++;
        }

        if (open != close) {
            System.out.print(-1);
            return;
        }

        int current = 0;
        int maxVal = 0;
        int minVal = 0;

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '(') {
                current++;
            } else {
                current--;
            }
            maxVal = Math.max(maxVal, current);
            minVal = Math.min(minVal, current);
        }

        System.out.print(Math.max(maxVal, Math.abs(minVal)));
    }
}