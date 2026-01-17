class Solution {
    public String solution(String phone_number) {
        String[] number = phone_number.split("");
        for(int i = phone_number.length() - 5; i >= 0; i--){
            number[i] = "*";
        }
        String answer = String.join("", number);
        return answer;
    }
}