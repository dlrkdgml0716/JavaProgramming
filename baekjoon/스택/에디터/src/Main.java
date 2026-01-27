import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            leftStack.push(str.charAt(i));
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command) {
                case "L":
                    if(!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;

                case "D":
                    if(!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;

                case "B":
                    if(!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;

                case "P":
                    char t = st.nextToken().charAt(0);
                    leftStack.push(t);
                    break;
            }
        }
        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}