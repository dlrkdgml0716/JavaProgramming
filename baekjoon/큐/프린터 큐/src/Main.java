import java.util.*;
import java.io.*;

public class Main {
    static class Doc {
        public int id;
        public int point;
        public Doc(int id, int point) {
            this.id = id;
            this.point = point;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chance = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chance; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Deque<Doc> deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                deque.add(new Doc(j, Integer.parseInt(st.nextToken())));
            }

            int count = 0;

            while (!deque.isEmpty()) {
                Doc current = deque.poll();
                boolean hasHigher = false;
                for (Doc d : deque) {
                    if (d.point > current.point) {
                        hasHigher = true;
                        break;
                    }
                }
                if (hasHigher) {
                    deque.addLast(current);
                } else {
                    count++;
                    if (current.id == m) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}

// 스택과 큐 자료구조를 사용하여 자료들을 순차적으로 비교해야 될때 **for each** 문 적극 활용하기 -> 자꾸 까먹음