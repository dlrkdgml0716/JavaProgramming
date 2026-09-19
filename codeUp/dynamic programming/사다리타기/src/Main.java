import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());

        char[] target = br.readLine().trim().toCharArray();
        char[][] map = new char[n][];
        int hidden = -1;

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().trim().toCharArray();
            if (map[i][0] == '?') hidden = i;
        }

        char[] up = new char[k];
        for (int i = 0; i < k; i++) up[i] = (char) ('A' + i);
        for (int i = 0; i < hidden; i++) apply(up, map[i]);

        char[] down = target.clone();
        for (int i = n - 1; i > hidden; i--) apply(down, map[i]);

        char[] answer = new char[k - 1];
        Arrays.fill(answer, '*');
        boolean possible = true;

        for (int j = 0; j < k - 1; j++) {
            if (up[j] == down[j]) continue;

            if (j > 0 && answer[j - 1] == '-') { possible = false; break; }

            answer[j] = '-';
            char tmp = up[j];
            up[j] = up[j + 1];
            up[j + 1] = tmp;

            if (up[j] != down[j]) { possible = false; break; }
        }

        if (possible && up[k - 1] != down[k - 1]) possible = false;

        StringBuilder sb = new StringBuilder();
        if (possible) {
            sb.append(answer);
        } else {
            for (int i = 0; i < k - 1; i++) sb.append('x');
        }
        System.out.print(sb);
    }

    static void apply(char[] order, char[] line) {
        for (int j = 0; j < line.length; j++) {
            if (line[j] == '-') {
                char tmp = order[j];
                order[j] = order[j + 1];
                order[j + 1] = tmp;
            }
        }
    }
}