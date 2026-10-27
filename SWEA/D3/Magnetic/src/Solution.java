import java.util.*;

public class Solution{
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 10; i++){
            int size = sc.nextInt();
            int[][] map = new int[size][size];
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    map[j][k] = sc.nextInt();
                }
            }

            int count = 0;
            for(int j = 0; j < size; j++){
                Stack<Integer> stack = new Stack<>();
                for(int k = 0; k < size; k++){
                    stack.add(map[k][j]);
                }

                while(!stack.isEmpty()){
                    int top = stack.pop();
                    if(top != 2) continue;

                    while(!stack.isEmpty() && stack.peek() != 1){
                        stack.pop();
                    }

                    if (!stack.isEmpty()) {
                        count++;
                    }
                }
            }
            System.out.println("#" + i + " " + count);
        }
    }
}