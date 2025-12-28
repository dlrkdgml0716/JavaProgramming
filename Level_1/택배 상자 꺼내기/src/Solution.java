class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        int numRow = (num - 1) / w;
        int numCol = getColumn(num, w, numRow);

        int maxRow = (n - 1) / w;

        for (int row = numRow; row <= maxRow; row++) {
            int currentNum = getNumberByPos(row, numCol, w);

            if (currentNum <= n) {
                answer++;
            }
        }
        return answer;
    }

    private int getNumberByPos(int row, int col, int w) {
        int start = row * w;
        if (row % 2 == 0) {
            return start + col + 1;
        } else {
            return start + (w - col);
        }
    }

    private int getColumn(int num, int w, int row) {
        int remain = (num - 1) % w;
        if (row % 2 == 0) {
            return remain;
        } else {
            return (w - 1) - remain;
        }
    }
}

// 문제를 해결하는 순서 1. 작은 수의 예시로 출력값 구해보기 2. 패턴찾기 3. 기능 별 함수 단위 추상화하기 4. 제약 사항 확인하기 5. Pseudo Code코드 작성하기
// 로직을 짤 때 방해되는 요소는 우선 무시하고 규칙을 만든 뒤 예외처리 해주기