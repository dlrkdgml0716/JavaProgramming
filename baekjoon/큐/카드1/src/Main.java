import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int chance = scanner.nextInt();
        for(int i = 1; i <= chance; i++){
            queue.add(i);
        }
        while(queue.size() != 1){
            System.out.print(queue.poll() + " ");
            if (queue.size() == 1) break;
            int top = queue.poll();
            queue.add(top);
        }
        System.out.print(queue.peek());
    }
}