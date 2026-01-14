import java.util.*;

class Solution {
    private boolean check(int doll, Stack<Integer> st){
        if(!st.isEmpty() && doll == st.peek()){
            st.pop();
            return true;
        }
        return false;
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stackInt = new Stack<>();

        for(int num : moves){
            int col = num - 1;

            for(int i = 0; i < board.length; i++){
                if(board[i][col] != 0){
                    int currentDoll = board[i][col];

                    if(check(currentDoll, stackInt)){
                        answer += 2;
                    } else {
                        stackInt.push(currentDoll);
                    }

                    board[i][col] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}