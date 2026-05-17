class Solution {
    int answer = 0;
    int count = 0;
    boolean found = false;
    String[] vowels = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        dfs("", word, 0);
        return answer;
    }
    private void dfs(String str, String target, int len) {
        if (len > 5 || found) return;
        if (!str.equals("")) {
            count++;
            if (str.equals(target)) {
                answer = count;
                found = true;
                return;
            }
        }
        for (int i = 0; i < 5; i++) {
            dfs(str + vowels[i], target, len + 1);
        }
    }
}