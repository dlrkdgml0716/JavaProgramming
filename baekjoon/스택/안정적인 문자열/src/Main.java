import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        while(true){
            int edit = 0;
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            if(s.contains("-")) return;
            count++;

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '{') stack.push(c);
                else if(!stack.empty() && stack.peek() == '{') stack.pop();
                else stack.push(c);
            }

            while(!stack.empty()){
                char c1 = stack.pop();
                char c2 = stack.pop();
                if(c1 == c2) edit += 1;
                else edit += 2;
            }
            System.out.println(count+". "+edit);
        }
    }
}