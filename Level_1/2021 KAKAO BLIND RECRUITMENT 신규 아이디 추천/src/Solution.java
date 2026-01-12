class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^0-9a-z-_.]", "");
        answer = answer.replaceAll("\\.{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");
        answer = answer.equals("") ? "a" : answer;
        answer = answer.length() >= 16 ? answer.substring(0, 15) : answer;
        answer = answer.replaceAll("[.]$", "");
        char lastCh = answer.charAt(answer.length() - 1);
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += lastCh;
            }
        }
        return answer;
    }
}
// 정규식 표현 공부