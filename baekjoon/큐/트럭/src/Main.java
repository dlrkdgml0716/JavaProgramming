import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 차량 수
        int bridgeLength = Integer.parseInt(st.nextToken()); // 다리 길이
        int bridgeWeight = Integer.parseInt(st.nextToken()); // 다리 견딜 수 있는 무게

        st = new StringTokenizer(br.readLine());
        Queue<Integer> waitQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            waitQueue.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridgeLength; i++) {
            bridge.add(0);
        }

        int time = 0;
        int currentWeight = 0;

        while (!bridge.isEmpty()) {
            time++;
            currentWeight -= bridge.poll();

            if (!waitQueue.isEmpty()) {
                if (currentWeight + waitQueue.peek() <= bridgeWeight) {
                    int nextCar = waitQueue.poll();
                    bridge.add(nextCar);
                    currentWeight += nextCar;
                } else {
                    bridge.add(0);
                }
            }
        }

        System.out.println(time);
    }
}