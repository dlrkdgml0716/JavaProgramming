import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> li = new ArrayList<>();

        for(int i = 0; i < score.length; i++) {
            li.add(score[i]);

            Collections.sort(li);

            if(li.size() > k) {
                li.remove(0);
            }

            answer[i] = li.get(0);
        }

        return answer;
    }
}

// List<>를 이용하여 크기가 동적인 배열만들기