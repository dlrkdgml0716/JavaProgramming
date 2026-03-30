import java.util.*;

class Solution {
    public int solution(int n) {
        int num = n;
        int originN = oneOfBinary(num);
        while(true){
            num++;
            int targetN = oneOfBinary(num);
            if(originN == targetN) return num;
        }
    }
    public int oneOfBinary(int n){
        int count = 0;
        while(n > 1){
            if(n%2 == 1) count++;
            n = n/2;
        }
        return count;
    }
}