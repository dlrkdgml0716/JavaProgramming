import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                int a = stack.pop();
                int b = stack.pop();
                switch(c){
                    case '+': stack.add(b+a); break;
                    case '-': stack.add(b-a); break;
                    case '*': stack.add(b*a); break;
                    case '/': stack.add(b/a); break;
                    default: break;
                }
            }
            else{
                stack.push(c - '0');
            }
        }
        System.out.print(stack.pop());
    }
}

// char 타입 숫자를 숫자로 출력하고 싶으면 char c - '0' 또는 Character.getNumericValue(c)