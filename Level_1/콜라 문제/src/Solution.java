class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int num = n;
        while(true){
            if(num >= a){
                if(num%a == 0){
                    answer += num/a * b;
                    num = num/a * b;
                }
                else{
                    answer += (num/a) * b;
                    num = (num/a) * b + num%a;
                }
            }
            else{
                break;
            }
        }
        return answer;
    }
}