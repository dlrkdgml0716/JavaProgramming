class Solution {
    public int solution(int n) {
        int answer = 0;
        int temp = n;
        for(int i = n-1; i > 0; i--){
            if(n % i == 1 && i < n){
                answer = i;
            }
        }
        return answer;
    }
}