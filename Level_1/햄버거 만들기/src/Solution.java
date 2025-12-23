import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int in : ingredient) {
            stack.push(in);

            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 &&
                        stack.get(size - 3) == 2 &&
                        stack.get(size - 2) == 3 &&
                        stack.get(size - 1) == 1) {

                    answer++;
                    stack.pop(); stack.pop(); stack.pop(); stack.pop();
                }
            }
        }
        return answer;
    }
}

// 만약 ingredient 길이가 길어지면 List를 사용할 때 중간 index를 제거하면 자리 채우는 과저에서 시간이 오래걸림
// 그래서 stack을 사용하여 넣을 때마다 조건을 검사 후 날리면 더 효율적임