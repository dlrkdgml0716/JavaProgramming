import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cows = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < cows; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int speed = Integer.parseInt(st.nextToken());
            stack.push(speed);
        }

        Stack<Integer> group = new Stack<>();
        while(!stack.empty()){
            int speed = stack.pop();
            if(group.empty()) group.push(speed);
            else if(group.peek() >= speed) group.push(speed);
        }
        System.out.print(group.size());
    }
}