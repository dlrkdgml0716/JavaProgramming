import java.io.*;
import java.util.*;

public class Main {
    static class Student{
        String s;
        int id;
        public Student(String s, int num){
            this.s = s;
            this.id = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int candidates = Integer.parseInt(br.readLine());

        Queue<Student> queue = new ArrayDeque<>();
        for(int i = 0; i < candidates; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String who = st.nextToken();
            int stdId = Integer.parseInt(st.nextToken());
            queue.add(new Student(who, stdId));
        }

        while (queue.size() > 1) {
            Student current = queue.poll();
            int moveCount = (current.id - 1) % queue.size();

            for (int j = 0; j < moveCount; j++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        if(!queue.isEmpty()){
            System.out.print(queue.peek().s);
        }
    }
}