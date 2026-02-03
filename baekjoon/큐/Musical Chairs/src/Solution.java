import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while(!queue.isEmpty() && queue.size() != 1) {
            int first = queue.peek()[1];
            int target = (-1 + first) % queue.size();
            for(int i = 0; i < target; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        if(!queue.isEmpty()) System.out.print(queue.peek()[0]+1);
    }
}