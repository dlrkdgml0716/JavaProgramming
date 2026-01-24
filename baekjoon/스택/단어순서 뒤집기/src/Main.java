import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Stack<String> stack = new Stack<>();
        int chance = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < chance; i++) {
            StringBuilder sb = new StringBuilder();
            String s = scanner.nextLine();
            for (String str : s.split(" ")) {
                stack.push(str);
            }
            while(!stack.empty()){
                String str = stack.pop();
                sb.append(str+" ");
            }
            System.out.println("Case #" + (i+1) + ": " + sb.toString().trim());
        }
    }
}
