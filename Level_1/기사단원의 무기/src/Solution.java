class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int count = 0;

            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    count++;
                    if (j != i / j) {
                        count++;
                    }
                }
            }

            answer += count > limit ? power : count;
        }

        return answer;
    }
}


// 10의 약수는 1,2,5,10인데, 5 이후부터는 10말고는 약수가 없죠.
// 그리고 5는 2와 함께하는 약수이고요. 이게 값이 커지면 커질수록 약수가 아닌 숫자들이 많아지면서 그 시간이 오래 걸릴거예요.
// 100만 해도 10보다 10배 많은 숫자를 확인하게 되죠.
//필요하지 않은 과정을 줄이는게 실행시간을 줄이는 방법인 거예요.