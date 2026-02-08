import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int birds = Integer.parseInt(br.readLine());
        Deque<String>[] deques = new ArrayDeque[birds];

        for(int i = 0; i < birds; i++){
            deques[i] = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                deques[i].add(st.nextToken());
            }
        }

        String message = br.readLine();
        StringTokenizer st = new StringTokenizer(message);
        boolean possible = true;

        while(st.hasMoreTokens()){
            String target = st.nextToken();
            boolean foundInAnyBird = false;

            for(int i = 0; i < birds; i++){
                if(!deques[i].isEmpty() && deques[i].peek().equals(target)){
                    deques[i].poll();
                    foundInAnyBird = true;
                    break;
                }
            }
            if(!foundInAnyBird) {
                possible = false;
                break;
            }
        }
        for(int i = 0; i < birds; i++){
            if(!possible || !deques[i].isEmpty()) possible = false;
        }
        if(possible) System.out.print("Possible");
        else System.out.print("Impossible");
    }
}