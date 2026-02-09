import java.util.*;
import java.io.*;

public class Main {
    static class State {
        int price;
        boolean possible;
        public State(int price, boolean possible) {
            this.price = price;
            this.possible = possible;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int parkSpace = Integer.parseInt(st.nextToken());
        int cars = Integer.parseInt(st.nextToken());

        State[] space = new State[parkSpace];
        for (int i = 0; i < parkSpace; i++) {
            space[i] = new State(Integer.parseInt(br.readLine()), true);
        }

        int[] weightOfCar = new int[cars + 1];
        for (int i = 1; i <= cars; i++) {
            weightOfCar[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] occupiedSpace = new int[cars + 1];
        int currentOccupied = 0;

        for (int i = 0; i < cars * 2; i++) {
            int currentState = Integer.parseInt(br.readLine());

            if (currentState > 0) {
                queue.add(currentState);
            } else {
                int targetCar = Math.abs(currentState);
                int spaceIdx = occupiedSpace[targetCar];
                space[spaceIdx].possible = true;
                currentOccupied--;
            }

            while (!queue.isEmpty() && currentOccupied < parkSpace) {
                for (int j = 0; j < parkSpace; j++) {
                    if (space[j].possible) {
                        int carToPark = queue.poll();
                        space[j].possible = false;
                        occupiedSpace[carToPark] = j;
                        currentOccupied++;
                        total += weightOfCar[carToPark] * space[j].price;
                        break;
                    }
                }
            }
        }
        System.out.println(total);
    }
}