import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int n = st.pop();
            if(n != arr[i]){
                st.push(n);
                st.push(arr[i]);
            }
            else{
                st.push(n);
            }
        }
        int[] answer = new int[st.size()];
        for(int i = answer.length - 1; i >= 0; i--){
            answer[i] = st.pop();
        }
        return answer;
    }
}