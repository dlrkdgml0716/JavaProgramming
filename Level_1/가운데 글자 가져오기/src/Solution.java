class Solution {
    public String solution(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        if(n%2 == 0){
            for(int i = (n/2)-1; i <= n/2; i++){
                char c = s.charAt(i);
                sb.append(c);
            }
        }
        else sb.append(s.charAt(n/2));

        return sb.toString();
    }
}