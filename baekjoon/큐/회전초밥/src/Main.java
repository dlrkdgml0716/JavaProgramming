import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer>[] waitersPerDish = new ArrayDeque[200001];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int dishId = Integer.parseInt(st.nextToken());
                if (waitersPerDish[dishId] == null) {
                    waitersPerDish[dishId] = new ArrayDeque<>();
                }
                waitersPerDish[dishId].add(i);
            }
        }

        int[] eatCount = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int currentDish = Integer.parseInt(st.nextToken());

            if (waitersPerDish[currentDish] != null && !waitersPerDish[currentDish].isEmpty()) {
                int customerIdx = waitersPerDish[currentDish].poll();
                eatCount[customerIdx]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(eatCount[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}