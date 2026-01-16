import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) scores[0]++;
            if (answers[i] == two[i % two.length]) scores[1]++;
            if (answers[i] == three[i % three.length]) scores[2]++;
        }

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        List<Integer> list = new ArrayList<>();
        if (maxScore == scores[0]) list.add(1);
        if (maxScore == scores[1]) list.add(2);
        if (maxScore == scores[2]) list.add(3);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
// 서로 다른 특정 구간을 반복해야할 때 나머지 연산자 사용하기