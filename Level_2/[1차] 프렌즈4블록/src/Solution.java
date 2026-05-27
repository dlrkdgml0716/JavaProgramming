class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char [][] map = new char[m][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                map[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            boolean[][] check = new boolean[m][n];
            boolean hit = false;
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    char c = map[i][j];
                    if (c == '-') continue;
                    if(map[i][j+1] == c && map[i+1][j+1] == c && map[i+1][j] == c){
                        check[i][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j+1] = true;
                        check[i+1][j] = true;
                        hit = true;
                    }
                }
            }
            if(!hit) break;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        map[i][j] = '-';
                        answer++;
                    }
                }
            }
            for(int i = m-1; i >= 0; i--){
                for(int j = 0; j < n; j++){
                    if(map[i][j] == '-'){
                        for(int k = i-1; k >=0; k--){
                            if(map[k][j] != '-'){
                                map[i][j] = map[k][j];
                                map[k][j] = '-';
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}