import java.util.*;
import java.io.*;

public class Main {
    static class Task {
        int score;
        int time;

        Task(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Task> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int total = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                time--;

                if (time == 0) {
                    total += score;
                } else {
                    stack.push(new Task(score, time));
                }
            } else {
                if (!stack.isEmpty()) {
                    Task current = stack.peek();
                    current.time--;

                    if (current.time == 0) {
                        total += current.score;
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(total);
    }
}