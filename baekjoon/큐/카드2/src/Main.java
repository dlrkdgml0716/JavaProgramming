import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Queue<Integer> queue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i = 1; i <= num; i++){
            queue.add(i);
        }
        while(!queue.isEmpty() && queue.size() != 1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.print(queue.poll());
    }
}