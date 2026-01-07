import java.lang.Math;
class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        long total = 0;
        for(int i = 1; i <= count; i++){
            total += price * i;
        }
        if(answer - total > 0){
            return 0;
        }
        else{
            return Math.abs(answer-total);
        }
    }
}