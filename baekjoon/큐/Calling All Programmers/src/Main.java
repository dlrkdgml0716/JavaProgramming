import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0 && k == 0) break;

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }
            for (int j = 0; j < k; j++) {
                for (int count = 0; count < m - 1; count++) {
                    queue.add(queue.poll());
                }
                if (j == k - 1) {
                    System.out.println(queue.peek());
                } else {
                    queue.poll();
                }
            }
        }
    }
}
// 나머지 연산자를 사용하여 (현재 인덱스 + 이동할 칸) % 전체 사이즈를 하면 queue에 값을 계속 빼고 넣는 작업을 하지 않고도 수행가능