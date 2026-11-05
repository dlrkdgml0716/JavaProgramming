import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        for(int i = 1; i <= 10; i++){
            Stack<Integer> stack = new Stack<>();
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int N  = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for(int j = s.length()-1; j >= 0; j--){
                if(!stack.isEmpty() && stack.peek() == s.charAt(j) - '0') stack.pop();
                else stack.push(s.charAt(j) - '0');
            }
            System.out.print("#" + i + " ");
            while(!stack.isEmpty()){
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }
}