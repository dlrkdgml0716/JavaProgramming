import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Deque<Integer> queue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chance = Integer.parseInt(br.readLine());

        for(int i = 0; i < chance; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!queue.isEmpty()) System.out.println(queue.poll());
                    else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(!queue.isEmpty()) System.out.println(0);
                    else System.out.println(1);
                    break;
                case "front":
                    if(!queue.isEmpty()) System.out.println(queue.peek());
                    else System.out.println(-1);
                    break;
                case "back":
                    if(!queue.isEmpty()) System.out.println(queue.peekLast());
                    else System.out.println(-1);
                    break;
                default:
                    break;
            }
        }
    }
}