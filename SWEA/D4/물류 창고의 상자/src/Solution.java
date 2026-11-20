import java.util.*;

public class Solution {
    static List<Stack<Integer>> li;
    static int N;
    static int H;
    static int Q;
    static int fail;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            N = sc.nextInt(); // 보관 구역의 개수
            H = sc.nextInt(); // 최대 상자 개수
            Q = sc.nextInt(); // 명령 개수
            fail = 0;
            li = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                li.add(new Stack<>());
                int S = sc.nextInt();
                for(int k = 0; k < S; k++) {
                    li.get(j).push(sc.nextInt());
                }
            }
            int[][] command = new int[Q][3];
            for(int j = 0; j < Q; j++) {
                for(int k = 0; k < 3; k++) {
                    command[j][k] = sc.nextInt();
                }
            }

            for(int j = 0; j < Q; j++) {
                int give = command[j][0];
                int take = command[j][1];
                int count = command[j][2];
                if(give == take || !possibleMove(take, count) || !possibleGive(give, count)) {
                    fail++;
                    continue;
                }
                Stack<Integer> temp = new Stack<>();
                for(int l = 0; l < count; l++) {
                    temp.push(li.get(give-1).pop());
                }
                for(int l = 0; l < count; l++) {
                    li.get(take-1).push(temp.pop());
                }
            }
            System.out.print("#" + i + " " + fail);
            for(Stack stack : li) {
                if(stack.size() == 0) System.out.print(" 0");
                else System.out.print(" " + stack.pop());
            }
            System.out.println();
        }
    }
    static boolean possibleMove(int take, int count) {
        int countT = li.get(take-1).size();

        if(countT + count > H) return false;
        return true;
    }
    static boolean possibleGive(int give, int count) {
        int countG = li.get(give-1).size();

        if(countG < count) return false;
        return true;
    }
}
