class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        long standard = Long.parseLong(p);
        StringBuilder sb = new StringBuilder(t);

        for(int i = 0; i <= t.length() - length; i++){
            String str = sb.substring(i, i+length);
            Long num = Long.parseLong(str);
            if(standard >= num){
                answer++;
            }
        }
        return answer;
    }
}