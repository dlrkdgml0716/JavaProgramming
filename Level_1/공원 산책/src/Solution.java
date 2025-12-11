import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {

        int x = 0;
        int y = 0;

        char[][] parkWay = new char[park.length][park[0].length()];

        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                char c = park[i].charAt(j);
                parkWay[i][j] = c;
                if(c == 'S'){
                    x = i;
                    y = j;
                }
            }
        }

        for(int i = 0; i < routes.length; i++){
            String[] arr = routes[i].split(" ");
            String op = arr[0];
            int dist = Integer.parseInt(arr[1]);

            int tempX = 0;
            int tempY = 0;
            boolean canMove = true;

            if(op.equals("E")){
                if(y + dist >= parkWay[0].length) continue;
                for(int j = 1; j <= dist; j++){
                    if(parkWay[x][y + j] == 'X'){
                        canMove = false;
                        break;
                    }
                    tempY++;
                }
                if(canMove) y += tempY;
            }

            else if(op.equals("W")){
                if(y - dist < 0) continue;

                for(int j = 1; j <= dist; j++){
                    if(parkWay[x][y - j] == 'X'){
                        canMove = false;
                        break;
                    }
                    tempY--;
                }
                if(canMove) y += tempY;
            }

            else if(op.equals("S")){
                if(x + dist >= parkWay.length) continue;

                for(int j = 1; j <= dist; j++){
                    if(parkWay[x + j][y] == 'X'){
                        canMove = false;
                        break;
                    }
                    tempX++;
                }
                if(canMove) x += tempX;
            }

            else if(op.equals("N")){
                if(x - dist < 0) continue;

                for(int j = 1; j <= dist; j++){
                    if(parkWay[x - j][y] == 'X'){
                        canMove = false;
                        break;
                    }
                    tempX--;
                }
                if(canMove) x += tempX;
            }
        }

        return new int[]{x, y};
    }
}