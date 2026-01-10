import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String s : strNums) {
            answer.append(s);
        }

        return answer.toString();
    }
}

// Arrays. sort의 조건을 (a, b) -> (b + a).compareTo(a + b) 하여 내림차순으로 정렬
// compareTo는 사전순(유니코드) 값으로 비교, 만약 b+a가 a+b보다 크다면 b가 a보다 큼 -> 정수를 반환하여 a, b 순서를 바꿈
// 음수나 0을 반환하면 순서 유지