class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int idk = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0) idk++;
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]) count++;
            }
        }
        if(idk > 0){
            answer[0] = awards(idk + count);
            answer[1] = awards(count);
        }
        else{
            answer[0] = awards(count);
            answer[1] = awards(count);
        }
        return answer;
    }
    private int awards(int count){
        if(count == 2) return 5;
        else if(count == 3) return 4;
        else if(count == 4) return 3;
        else if(count == 5) return 2;
        else if(count == 6) return 1;
        else return 6;
    }
}