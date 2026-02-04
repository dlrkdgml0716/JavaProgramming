import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> unWashed = new Stack<>();
        Stack<Integer> washed = new Stack<>();
        Stack<Integer> dried = new Stack<>();
        int dishes = Integer.parseInt(br.readLine());

        for(int i = dishes; i > 0; i--){
            unWashed.push(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!unWashed.empty() || !washed.empty()){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int who = Integer.parseInt(st.nextToken());
            int act = Integer.parseInt(st.nextToken());
            switch(who){
                case 1:
                    for(int j = 0; j < act; j++) washed.push(unWashed.pop());
                    break;
                case 2:
                    for(int k = 0; k < act; k++) dried.push(washed.pop());
                    break;
                default:
                    break;
            }
        }
        while(!dried.empty()){
            sb.append(dried.pop()).append("\n");
        }
        System.out.print(sb.toString());
    }
}