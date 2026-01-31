import  java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < T; i++){
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            stack.push(s.charAt(0));
            for(int j = 1; j < s.length(); j++){
                char c = s.charAt(j);
                if(!stack.empty() && stack.peek() == c){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
            if(stack.empty()) count++;
        }
        System.out.println(count);
    }
}