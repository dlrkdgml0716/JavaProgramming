import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++){
            int K = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] platform = new int[N+1];
            for(int j = 0; j < M; j++){
                platform[sc.nextInt()] = 1;
            }

            int current = 0;
            int count = 0;
            while(current + K < N){
                int next = -1;
                for(int j = current+K; j > current; j--){
                    if(platform[j] == 1){
                        next = j;
                        count++;
                        break;
                    }
                }
                if(next == -1){
                    count = 0;
                    break;
                }
                current = next;
            }
            System.out.println("#" + i + " " + count);
        }
    }
}