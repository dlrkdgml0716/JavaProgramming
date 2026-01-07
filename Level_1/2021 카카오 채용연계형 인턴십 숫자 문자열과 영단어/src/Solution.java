class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] digit = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < 10; i++){
            s = s.replace(digit[i], String.valueOf(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}
}