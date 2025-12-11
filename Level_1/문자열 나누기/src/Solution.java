class Solution {
    public int solution(String s) {
        int answer = 0;
        char firstCh = s.charAt(0);
        int machNum = 0;
        int difNum = 0;

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            if (machNum == 0 && difNum == 0) {
                firstCh = s.charAt(i);
            }
            if(firstCh == ch1){
                machNum++;
            }
            else if(firstCh != ch1){
                difNum++;
            }
            if(machNum == difNum){
                machNum = 0;
                difNum = 0;
                answer++;
            }
        }
        if(machNum != 0 || difNum != 0) {
            answer++;
        }

        return answer;
    }
}