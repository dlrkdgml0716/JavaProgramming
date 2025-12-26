import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int idx = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                idx++;
                if (c == '1' && dartResult.charAt(i + 1) == '0') {
                    score[idx] = 10;
                    i++;
                } else {
                    score[idx] = c - '0';
                }
            }
            else if (c == 'S') score[idx] = (int)Math.pow(score[idx], 1);
            else if (c == 'D') score[idx] = (int)Math.pow(score[idx], 2);
            else if (c == 'T') score[idx] = (int)Math.pow(score[idx], 3);
            else if (c == '*') {
                score[idx] *= 2;
                if (idx > 0) score[idx - 1] *= 2;
            } else if (c == '#') {
                score[idx] *= -1;
            }
        }

        return score[0] + score[1] + score[2];
    }
}

// 자바에서 char, byte, short 타입의 데이터가 산술 연산자(+, -, *, /)를 만나면,
// 자바 가상 머신(JVM)은 이를 자동으로 int 타입으로 변환하여 계산
// 어떤 숫자 문자에서 '0'의 아스키 값을 빼면, 그 문자가 상징하는 실제 숫자 값을 얻을 수 있음