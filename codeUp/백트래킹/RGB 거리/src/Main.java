import java.util.*;
public class Main {
    static int min;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        min = Integer.MAX_VALUE;
        int[][] house = new int[N][3];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 3; j++){
                house[i][j] = scanner.nextInt();
            }
        }
        paintHome(N, house, 0, -1, 0);
        System.out.print(min);
    }
    public static void paintHome(int n, int[][] house, int depth, int prevColor, int current){
        if(current >= min) return;
        if(depth == n){
            if(min > current) min = current;
            return;
        }
        for(int i = 0; i < 3; i++){
            if(i != prevColor){
                paintHome(n, house, depth+1, i,current+house[depth][i]);
            }
        }
    }
}
