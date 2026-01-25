import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int chance = Integer.parseInt(br.readLine());

        for(int i = 0; i < chance; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop")){
                if(stack.empty()) sb.append("-1").append('\n');
                else sb.append(stack.pop()).append('\n');
            }
            else if(command.equals("size")){
                sb.append(stack.size()).append('\n');
            }
            else if(command.equals("empty")){
                if(stack.empty()) sb.append("1").append('\n');
                else sb.append("0").append('\n');
            }
            else if(command.equals("top")){
                if(stack.empty()) sb.append("-1").append('\n');
                else sb.append(stack.peek()).append('\n');
            }
        }
        System.out.println(sb);
    }
}
// 데이터의 개수가 많거나 시간 제한이 빡빡한 문제에서는 BufferedReader와 StringBuilder 조합 사용