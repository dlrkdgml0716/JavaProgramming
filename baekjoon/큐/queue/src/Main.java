import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Deque<Integer> queue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chance = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < chance; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!queue.isEmpty()) sb.append(queue.poll()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(!queue.isEmpty()) sb.append(0).append("\n");
                    else sb.append(1).append("\n");
                    break;
                case "front":
                    if(!queue.isEmpty()) sb.append(queue.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "back":
                    if(!queue.isEmpty()) sb.append(queue.peekLast()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
    }
}