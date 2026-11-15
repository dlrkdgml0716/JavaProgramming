import java.util.*;

public class Solution {
    static int total;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 1; i <= TC; i++) {
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> watting = new LinkedList<>();
            total = 0;
            n = sc.nextInt(); // 주차장 요금
            m = sc.nextInt(); // 차량 수

            int[] parkValue = new int[n+1]; // 자리 별 요금
            int[] parkState = new int[n+1]; // 자리 별 상태
            for(int j = 1; j <= n; j++) {
                parkValue[j] = sc.nextInt();
            }

            int[] carWeight = new int[m+1]; // 차량 별 무게
            for(int j = 1; j <= m; j++) {
                carWeight[j] = sc.nextInt();
            }

            for(int j = 0; j < 2*m; j++) {
                queue.add(sc.nextInt());
            }

            while(!queue.isEmpty() || !watting.isEmpty()) {
                int command = 0;
                int target = findEmpty(parkState);
                if(!watting.isEmpty() && target != 0) command = watting.poll();
                else command = queue.poll();

                if(command > 0) {
                    if(target != 0 ) {
                        parkState[target] = command;
                        total += carWeight[command] * parkValue[target];
                    }
                    else {
                        watting.add(command);
                    }
                }
                else {
                    parkState[findTarget(parkState, command*-1)] = 0;
                }
            }
            System.out.println("#" + i + " " + total);
        }
        sc.close();
    }
    static int findEmpty(int[] parkState) {
        for(int i = 1; i <= n; i++) {
            if(parkState[i] == 0) return i;
        }
        return 0;
    }
    static int findTarget(int[] parkState, int target) {
        int temp = 0;
        for(int i = 1; i <= n; i++) {
            if(parkState[i] == target) temp = i;
        }
        return temp;
    }
}