import java.util.*;
public class Main {
    static int count;
    public static void main(String[] args) {
        count = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] blocks = new int[k];
        for(int i = 0; i < k; i ++) blocks[i] = sc.nextInt();

        solved(n, k, blocks, 0, 0);
        System.out.print(count);
    }
    public static void solved(int n, int k, int[] blocks, int idx, int pos){
        if(idx == k) {
            count++;
            return;
        }
        for(int i = pos; i <= n - blocks[idx]; i++){
            solved(n, k, blocks, idx+1, i + blocks[idx] + 1);
        }
    }
}