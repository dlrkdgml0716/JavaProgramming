import java.util.*;
public class Main {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] candies = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                candies[i][j] = sc.nextInt();
            }
        }
        boolean[] visited = new boolean[size];
        count = 0;
        solved(candies, visited,0, 0);
        System.out.print(count);
    }
    public static void solved(int[][] candies, boolean[] visited, int current, int depth){
        if(depth == candies.length){
            if(count < current) count = current;
            return;
        }
        boolean check = false;
        for(int i = 0; i < candies.length; i++){
            if(!visited[i]){
                visited[i] = true;
                solved(candies, visited, current + candies[depth][i], depth+1);
                visited[i] = false;
            }
        }
    }
}