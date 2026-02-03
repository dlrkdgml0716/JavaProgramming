import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int people = Integer.parseInt(br.readLine());
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int sequence = 1;
        for(int i = 1; i <= people; i++){
            int num = Integer.parseInt(st.nextToken());
            stack.push(num);
            while(!stack.empty() && stack.peek() == sequence){
                stack.pop();
                sequence++;
            }
        }
        if(stack.empty()) System.out.print("Nice");
        else System.out.print("Sad");
    }
}