import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int minNum = N;
        int maxLine = 0;
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int command = Integer.parseInt(st.nextToken());
            switch(command){
                case 1:
                    int lastNum = Integer.parseInt(st.nextToken());
                    queue.add(lastNum);
                    if(maxLine < queue.size()) {
                        maxLine = queue.size();
                        minNum = lastNum;
                    }
                    else if(maxLine == queue.size() && minNum > lastNum){
                        minNum = lastNum;
                    }
                    break;
                case 2:
                    if(!queue.isEmpty()) queue.poll();
                    break;
                default:
                    break;
            }
        }
        System.out.print(maxLine + " " + minNum);
    }
}