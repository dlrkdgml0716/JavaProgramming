import java.util.*;
class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        Combination("", numbers);

        int count = 0;
        for(int num : set){
            if(isPrime(num)){
                count++;
            }
        }
        return count;
    }
    private void Combination(String s, String numbers){
        if(!s.equals("")){
            set.add(Integer.parseInt(s));
        }
        for(int i = 0; i < numbers.length(); i++){
            Combination(s+numbers.charAt(i), numbers.substring(0, i)+numbers.substring(i+1));
        }
    }
    private boolean isPrime(int n){
        if(n < 2) return false;
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0) count++;
        }
        if(count == 2) return true;
        else return false;
    }
}