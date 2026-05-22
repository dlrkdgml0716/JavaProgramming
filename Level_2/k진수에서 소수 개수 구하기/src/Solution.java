import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String converted = Integer.toString(n, k);
        String[] arr = converted.split("0");
        for(String s : arr){
            if(s.isEmpty()) continue;
            answer += isPrime(Long.parseLong(s));
        }
        return answer;
    }
    private int isPrime(long n){
        if(n < 2) return 0;
        int count = 0;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return 0;
        }
        return 1;
    }
}