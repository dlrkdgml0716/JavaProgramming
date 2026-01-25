import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int chance = scanner.nextInt();
        for(int i = 0; i < chance; i++){
            Stack<Character> stack = new Stack<>();
            String str = scanner.next();
            for(int j = 0; j < str.length(); j++){
                char c = str.charAt(j);
                if(c == '(') stack.push(c);
                else if(!stack.empty() && c == ')'){
                    stack.pop();
                }
                else if(stack.empty() && c == ')'){
                    stack.push(c);
                    break;
                }
            }
            if(stack.empty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
