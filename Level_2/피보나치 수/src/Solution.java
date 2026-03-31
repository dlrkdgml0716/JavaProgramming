class Solution {
    public int solution(int n) {
        long start = 0;
        int count = 1;
        long next = 1;

        while(count != n){
            count++;
            long temp = next;
            next = (start + next) % 1234567;
            start = temp;
        }
        return (int)next;
    }
}