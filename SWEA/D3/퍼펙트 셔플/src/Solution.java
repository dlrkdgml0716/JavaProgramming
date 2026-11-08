import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            int N = sc.nextInt();
            sc.nextLine();
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            Queue<String> queue1 = new LinkedList<>();
            Queue<String> queue2 = new LinkedList<>();

            for(int j = 0; j < N; j++){
                if(N % 2 == 0){
                    if(j <= N/2-1) queue1.add(st.nextToken());
                    else queue2.add(st.nextToken());
                }
                else{
                    if(j <= N/2) queue1.add(st.nextToken());
                    else queue2.add(st.nextToken());
                }
            }

            System.out.print("#" + i + " ");
            for(int j = 0; j < N; j++){
                if(j % 2 == 0) System.out.print(queue1.poll() + " ");
                else System.out.print(queue2.poll() + " ");
            }
            System.out.println();
        }
    }
}