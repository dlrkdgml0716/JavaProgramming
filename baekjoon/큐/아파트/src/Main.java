import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        for(int i = 0; i < N*2; i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        String lose = br.readLine();
        StringTokenizer st2 = new StringTokenizer(lose);
        while(!queue.isEmpty() && T-- > 0){
            int tiger = Integer.parseInt(st2.nextToken());
            for(int i = 0; i < tiger - 1; i++){
                queue.add(queue.poll());
            }
            sb.append(queue.peek()).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}