class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int[][] pos = {
                {3, 1},
                {0, 0}, {0, 1}, {0, 2},
                {1, 0}, {1, 1}, {1, 2},
                {2, 0}, {2, 1}, {2, 2}
        };

        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftPos = pos[num];
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightPos = pos[num];
            } else {
                int[] target = pos[num];
                int leftDist = Math.abs(target[0] - leftPos[0]) + Math.abs(target[1] - leftPos[1]);
                int rightDist = Math.abs(target[0] - rightPos[0]) + Math.abs(target[1] - rightPos[1]);

                if (leftDist < rightDist) {
                    sb.append("L");
                    leftPos = target;
                } else if (rightDist < leftDist) {
                    sb.append("R");
                    rightPos = target;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftPos = target;
                    } else {
                        sb.append("R");
                        rightPos = target;
                    }
                }
            }
        }
        return sb.toString();
    }
}