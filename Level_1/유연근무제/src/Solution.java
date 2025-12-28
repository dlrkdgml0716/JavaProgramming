class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        int sat;
        int sun;
        if(startday == 7){
            sat = 6;
            sun = 0;
        }
        else{
            sat = 6 - startday;
            sun = 7 - startday;
        }

        for(int i = 0; i < timelogs.length; i++){
            int limitTime = schedules[i] + 10;
            if (limitTime % 100 >= 60) {
                limitTime += 40;
            }
            for(int j = 0; j < timelogs[i].length; j++){
                if(j != sat && j != sun){
                    if(limitTime < timelogs[i][j]){
                        answer--;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}

// 시간 문제 60분 처리 잘해주기