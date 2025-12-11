import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int startX = 50;
        int startY = 50;
        int lastX = 0;
        int lastY = 0;

        char Desktop[][] = new char[wallpaper.length][wallpaper[0].length()];
        for(int i = 0; i < wallpaper.length; i++){
            int tempX;
            int tempY;

            for(int j = 0; j < wallpaper[0].length(); j++){
                Desktop[i][j] = wallpaper[i].charAt(j);
                if(Desktop[i][j] == '#'){
                    tempX = i;
                    tempY = j;

                    if(tempX < startX){
                        startX = tempX;
                    }
                    if(tempY < startY){
                        startY = tempY;
                    }
                    if(tempX > lastX){
                        lastX = tempX;
                    }
                    if(tempY > lastY){
                        lastY = tempY;
                    }
                }
            }
        }

        int[] answer = {startX, startY, lastX+1, lastY+1};
        return answer;
    }
}


// Math 클래스를 사용하면 더 좋은 코드가 됌
