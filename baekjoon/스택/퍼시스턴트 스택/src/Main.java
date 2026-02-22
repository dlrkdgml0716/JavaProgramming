import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chance = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> twoHistory = new Stack<>();
        for(int i = 0; i < chance; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "1": stack.push(Integer.parseInt(st.nextToken())); temp.push(1); break;
                case "2": twoHistory.push(stack.pop()); temp.push(2); break;
                case "3":
                    int target = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < target; j++) {
                        int what = temp.pop();
                        if(what == 1) stack.pop();
                        else if(what == 2) stack.push(twoHistory.pop());
                    }
                    break;
                case "4": System.out.println(stack.size()); break;
                case "5":
                    if(stack.empty()) System.out.println(-1);
                    else System.out.println(stack.peek());
                    break;
                default: break;
            }
        }
    }
}