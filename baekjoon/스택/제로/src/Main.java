import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int chance = scanner.nextInt();
        for(int i = 0; i < chance; i++){
            int num = scanner.nextInt();
            if(num != 0) stack.push(num);
            else if(!stack.empty()) stack.pop();
        }
        int answer = 0;
        while(!stack.empty()){
            int n = stack.pop();
            answer += n;
        }
        System.out.print(answer);
    }
}