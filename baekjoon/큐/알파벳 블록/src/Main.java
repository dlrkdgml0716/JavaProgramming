import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chance = Integer.parseInt(br.readLine());

        Deque<String> deque = new ArrayDeque<>();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < chance; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (!st.hasMoreTokens()) continue;

            String cmd = st.nextToken();

            if (cmd.equals("1")) {
                String str = st.nextToken();
                deque.addLast(str);
                history.push("LAST:" + str);
            }
            else if (cmd.equals("2")) {
                String str = st.nextToken();
                deque.addFirst(str);
                history.push("FIRST:" + str);
            }
            else if (cmd.equals("3")) {
                if (!history.isEmpty()) {
                    String lastAction = history.pop();
                    if (lastAction.startsWith("LAST")) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }
        }

        if (deque.isEmpty()) {
            System.out.println("0");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : deque) {
                sb.append(s);
            }
            System.out.println(sb);
        }
    }
}