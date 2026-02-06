import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int chance = Integer.parseInt(st.nextToken());
        int totalFlat = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stack = new Stack[7];
        for(int i = 1; i <= 6; i++){
            stack[i] = new Stack<>();
        }
        int count = 0;
        for(int i = 0; i < chance; i++){
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int flat = Integer.parseInt(st.nextToken());

            Stack<Integer> currentStack = stack[line];
            if(currentStack.empty()){
                count++;
                currentStack.push(flat);
            }
            else if(currentStack.peek() < flat){
                currentStack.push(flat);
                count++;
            }
            else{
                while(!currentStack.empty() && currentStack.peek() > flat){
                    currentStack.pop();
                    count++;
                }
                if((!currentStack.empty() && currentStack.peek() != flat) || currentStack.empty()){
                    currentStack.push(flat);
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
// stack, queue 등 자료구조가 여래개가 요구된다면 배열을 통해 해결