import  java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int answer = 1;
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n - 1; i++){
            int num = scanner.nextInt();
            stack.push(num);
        }
        int last = scanner.nextInt();
        while(!stack.empty()){
            int top = stack.pop();
            if(last < top){
                last = top;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
