import java.io.*;
import java.util.*;

public class Main {
    static class Container {
        int priority, weight;
        public Container(int priority, int weight) {
            this.priority = priority;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Container> rail = new LinkedList<>();
        int[] priorityCount = new int[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            rail.add(new Container(p, w));
            priorityCount[p]++;
        }

        Stack<Container> warehouse = new Stack<>();
        long totalCost = 0;
        int currentP = M;

        while (currentP >= 1) {
            if (priorityCount[currentP] == 0) {
                currentP--;
                continue;
            }

            Container c = rail.poll();

            if (c.priority == currentP) {
                List<Container> temp = new ArrayList<>();
                while (!warehouse.isEmpty() && warehouse.peek().priority == currentP
                        && warehouse.peek().weight < c.weight) {
                    Container popped = warehouse.pop();
                    totalCost += popped.weight;
                    temp.add(popped);
                }
                warehouse.push(c);
                totalCost += c.weight;
                priorityCount[currentP]--;

                for (int i = temp.size() - 1; i >= 0; i--) {
                    Container t = temp.get(i);
                    warehouse.push(t);
                    totalCost += t.weight;
                }
            } else {
                rail.add(c);
                totalCost += c.weight;
            }
        }
        System.out.println(totalCost);
    }
}