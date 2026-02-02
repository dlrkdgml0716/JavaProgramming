import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Queue<int[]> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int chance = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for(int i = 0; i < chance; i++){
            queue.add(new int[]{Integer.parseInt(st.nextToken()), i});
        }
        int turn = 0;
        int arr[] = new int[chance];

        while(!queue.isEmpty()){
            if(queue.peek()[0] == 1) {
                turn++;
                arr[queue.peek()[1]] = turn;
                queue.poll();
            }
            else {
                int[] head = {queue.peek()[0] - 1, queue.peek()[1]};
                queue.poll();
                queue.add(head);
                turn++;
            }
        }
        for(int num : arr) sb.append(num).append(" ");
        System.out.print(sb.toString().trim());
    }
}