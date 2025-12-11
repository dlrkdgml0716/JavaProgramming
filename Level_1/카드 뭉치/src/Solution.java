class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        String answer;
        boolean isPossible = true;
        int cards1Length = 0;
        int cards2Length = 0;

        for(int i = 0; i < goal.length; i++){
            if(cards1Length < cards1.length && goal[i].equals(cards1[cards1Length])){
                cards1Length++;
                isPossible = true;
            }
            else if(cards2Length < cards2.length && goal[i].equals(cards2[cards2Length])){
                cards2Length++;
                isPossible = true;
            }
            else{
                isPossible = false;
                break;
            }
        }
        if(isPossible){
            answer = "Yes";
        }
        else{
            answer = "No";
        }
        return answer;
    }
}