import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int combined = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (combined % 2 == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
                combined /= 2;
            }
            answer[i] = sb.reverse().toString();
        }
        return answer;
    }
}

// | 연산자는 두 숫자를 이진수로 늘어놓고, 같은 자릿수끼리 비교해서 둘 중 하나라도 1이면 결과값을 1로 만드는 연산