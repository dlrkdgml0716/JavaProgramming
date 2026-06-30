import java.util.*;
public class Main {
    static List<String> li;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        String[] inequality = s.split(" ");
        boolean[] visited = new boolean[10];
        li = new ArrayList<>();
        solved(K, inequality, visited, "",0);
        System.out.println(li.get(li.size() - 1));
        System.out.println(li.get(0));
    }
    public static void solved(int K, String[] inequality, boolean[] visited, String current, int depth){
        if(depth == K+1){
            li.add(current);
            return;
        }
        for (int j = 0; j <= 9; j++) {
            if (!visited[j]) {
                if (depth == 0 || checkCondition(current.charAt(depth - 1) - '0', j, inequality[depth - 1])) {
                    visited[j] = true;
                    solved(K, inequality, visited, current + String.valueOf(j), depth + 1);
                    visited[j] = false;
                }
            }
        }
    }
    public static boolean checkCondition(int prev, int current, String op) {
        if (op.equals("<")) return prev < current;
        if (op.equals(">")) return prev > current;
        return false;
    }
}