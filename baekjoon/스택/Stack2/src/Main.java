import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int chance = Integer.parseInt(br.readLine());

        for(int i = 0; i < chance; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String command = st.nextToken();

            switch(command){
                case "1":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "2":
                    if(!stack.empty()) sb.append(stack.pop()).append('\n');
                    else sb.append("-1\n");
                    break;
                case "3":
                    sb.append(stack.size()).append('\n');
                    break;
                case "4":
                    if(!stack.empty()) sb.append(0).append('\n');
                    else sb.append("1\n");
                    break;
                case "5":
                    if(!stack.empty()) sb.append(stack.peek()).append('\n');
                    else sb.append("-1\n");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}