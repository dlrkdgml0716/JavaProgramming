import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int animals = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= animals; i++){
            deque.add(i);
        }
        while(true){
            if(deque.size() < target) break;
            int count = target - 1;
            deque.add(deque.poll());
            while(count-- > 0){
                deque.poll();
            }
        }
        System.out.print(deque.poll());
    }
}