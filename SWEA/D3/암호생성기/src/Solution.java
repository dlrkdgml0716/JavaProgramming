import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 10; i++){
            Queue<Integer> queue = new LinkedList<>();
            int testCase = sc.nextInt();
            for(int j = 0; j < 8; j++){
                queue.add(sc.nextInt());
            }

            int n = 1;
            while(true){
                if(!queue.isEmpty() && queue.peek() - n > 0){
                    queue.add(queue.poll() - n);
                }
                else {
                    queue.poll();
                    queue.add(0);
                    break;
                }
                n++;
                if(n%6 == 0) n = 1;
            }
            System.out.print("#" + testCase);
            for(int j = 0; j < 8; j++){
                int num = queue.poll();
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }
}