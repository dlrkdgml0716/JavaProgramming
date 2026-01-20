class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int num1 = n;
        int num2 = m;
        while(num1 != 0 && num2 != 0){
            if(num1 > num2) num1 %= num2;
            else num2 %= num1;
        }
        answer[0] = num1 + num2;
        answer[1] = (n * m) / answer[0];
        return answer;
    }
}

// 최소 공배수는 두 수 곱하고 최대 공약수 나누기