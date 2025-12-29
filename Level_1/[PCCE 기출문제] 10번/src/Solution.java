import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int row = park.length;
        int col = park[0].length;
        Arrays.sort(mats);
        for(int i = mats.length -1; i >= 0; i--){
            int size = mats[i];
            for(int j = 0; j <= row - size; j++){
                for(int k = 0; k <= col - size; k++){
                    if(canPlace(park, j, k, size)) return size;
                }
            }
        }
        return -1;
    }
    private boolean canPlace(String[][] park, int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}