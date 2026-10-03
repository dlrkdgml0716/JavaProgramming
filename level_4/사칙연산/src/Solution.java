class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(arr[i*2]);
            maxDp[i][i] = num;
            minDp[i][i] = num;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= n - i; j++){
                int k = j + i -1;

                maxDp[j][k] = Integer.MIN_VALUE;
                minDp[j][k] = Integer.MAX_VALUE;

                for (int mid = j; mid < k; mid++) {
                    String operator = arr[mid * 2 + 1];

                    int max;
                    int min;

                    if (operator.equals("+")) {
                        max = maxDp[j][mid] + maxDp[mid + 1][k];
                        min = minDp[j][mid] + minDp[mid + 1][k];
                    } else {
                        max = maxDp[j][mid] - minDp[mid + 1][k];
                        min = minDp[j][mid] - maxDp[mid + 1][k];
                    }

                    maxDp[j][k] = Math.max(maxDp[j][k], max);
                    minDp[j][k] = Math.min(minDp[j][k], min);
                }

            }
        }
        return maxDp[0][n - 1];
    }
}