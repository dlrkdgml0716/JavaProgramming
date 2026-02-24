import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int chance = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> {
            long abs1 = Math.abs(o1);
            long abs2 = Math.abs(o2);
            if (abs1 == abs2) {
                return o1 < o2 ? -1 : 1;
            }
            return abs1 < abs2 ? -1 : 1;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chance; i++) {
            long num = Long.parseLong(br.readLine());
            if (num == 0){
                if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
                else sb.append(0).append("\n");
            }
            else pq.add(num);
        }
        System.out.print(sb);
    }
}