import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bufferSize = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        while(true){
            int packet = Integer.parseInt(br.readLine());
            if(packet == -1) break;
            else{
                if(packet != 0 && deque.size() < bufferSize) deque.add(packet);
                else if (packet == 0) deque.poll();
            }
        }

        StringBuilder sb = new StringBuilder();
        if(!deque.isEmpty()){
            int dequeSize = deque.size();;
            for(int i = 0; i < dequeSize; i++){
                sb.append(deque.poll()).append(" ");
            }
        }
        else sb.append("empty");

        System.out.print(sb.toString().trim());
    }
}