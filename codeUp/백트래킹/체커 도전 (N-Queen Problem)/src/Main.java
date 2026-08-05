import java.util.*;
public class Main {
    static List<String>queens;
    static int count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        queens = new ArrayList<>();
        count = 0;
        boolean[][] visited = new boolean[n][n];
        solved(n, 0,  visited, "");
        for(String s : queens){
            for(int i = 0; i < s.length(); i++){
                System.out.print(s.charAt(i));
            }
            System.out.println();
        }
        System.out.print(count);
    }
    static void solved(int n, int depth, boolean[][] visited, String current){
        if(depth == n){
            if(queens.size() != 3){
                queens.add(current);
            }
            count++;
            return;
        }
        for(int j = 0; j < n; j++){
            if(possible(n, visited, depth, j)){
                visited[depth][j] = true;
                solved(n, depth + 1, visited, current + (j+1) + " ");
                visited[depth][j] = false;
            }
        }
    }
    static boolean possible(int n, boolean[][] visited, int i, int j){
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(!visited[r][c]) continue;
                if(c == j) return false;
                if(r - c == i - j) return false;
                if(r + c == i + j) return false;
            }
        }
        return true;
    }
}