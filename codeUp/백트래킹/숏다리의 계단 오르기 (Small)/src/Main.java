import java.util.*;
public class Main {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        count = 0;
        int cooldown = 0;
        solved(N, 0, cooldown);
        System.out.print(count);
    }
    public static void solved(int N, int depth, int cooldown){
        if(depth > N) return;
        if(depth == N){
            count++;
            return;
        }
        if(cooldown == 0){
            solved(N, depth + 1, cooldown);
            solved(N, depth + 2, cooldown);
            cooldown += 2;
            solved(N, depth + 3, cooldown);
        }
        else{
            cooldown--;
            solved(N, depth + 1, cooldown);
            solved(N, depth + 2, cooldown);
        }
    }
}