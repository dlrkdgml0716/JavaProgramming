import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (String s : X.split("")) {
            countX[Integer.parseInt(s)]++;
        }

        for (String s : Y.split("")) {
            countY[Integer.parseInt(s)]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            int common = Math.min(countX[i], countY[i]);
            for (int j = 0; j < common; j++) {
                sb.append(i);
            }
        }

        String answer = sb.toString();

        if (answer.isEmpty()) return "-1";
        if (answer.startsWith("0")) return "0";

        return answer;
    }
}

// countX[Integer.parseInt(s)]++; 해당 코드는 index s번 자리에 +1을 하는 코드임
// 해당 문제에서 StringBuilder를 사용하는 이유는 ArrayListm를 사용하면
// for문을 통해 문자열을 합쳐주는 추가적인 작업이 필요하고
// String 배열을 사용할 경우 + 연산을 할 때마다 객체가 생성되어 메모리가 낭비되고 속도가 느려지기 때문이다.