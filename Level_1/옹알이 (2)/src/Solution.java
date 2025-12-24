class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            String current = babbling[i];
            boolean hasContinuous = false;
            for (String w : words) {
                if (current.contains(w + w)) {
                    hasContinuous = true;
                    break;
                }
            }
            if (hasContinuous) continue;
            for (String w : words) {
                current = current.replace(w, " ");
            }
            if (current.trim().length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}