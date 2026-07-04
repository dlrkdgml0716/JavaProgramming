import java.util.*;
public class Main {
    static int count;
    static int[] small;
    static boolean found;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] people = new int[9];
        for(int i = 0; i < 9; i++){
            people[i] = sc.nextInt();
        }
        small = new int[9];
        boolean[] visited = new boolean[9];
        count = 0;
        found = false;
        solved(people, 0, 0, 0, visited);

        Arrays.sort(small);
        for(int i = 0; i < 9; i++){
            if(small[i] != 0) System.out.println(small[i]);
        }
    }
    public static void solved(int[] people, int sum, int depth, int idx, boolean[] visited){
        if(sum > 100 || found) return;
        if(depth == 7){
            if(sum == 100){
                count++;
                for(int i = 0; i < 9; i++){
                    if(visited[i]) small[i] = people[i];
                }
                found = true;
            }
            return;
        }
        for(int i = idx; i < 9; i++){
            if(!visited[i]){
                visited[i] = true;
                solved(people, sum + people[i], depth + 1, i + 1, visited);
                visited[i] = false;
            }
        }
    }
}