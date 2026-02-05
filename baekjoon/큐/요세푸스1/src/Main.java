import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int people = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= people; i++){
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(queue.size() != 1){
            for(int i = 1; i < turn; i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll());
        System.out.print("<" + sb.toString().trim() + ">");
    }
}