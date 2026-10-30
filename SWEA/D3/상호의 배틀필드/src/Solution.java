import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            int H = sc.nextInt();
            int W = sc.nextInt();
            sc.nextLine();
            char[][] map = new char[H][W];

            for(int j = 0; j < H; j++){
                String s = sc.nextLine();
                for(int k = 0; k < W; k++){
                    map[j][k] = s.charAt(k);
                }
            }
            int N = sc.nextInt();
            char[] command = new char[N];
            sc.nextLine();
            String s = sc.nextLine();
            for(int j = 0; j < N; j++){
                command[j] = s.charAt(j);
            }

            int x = -1;
            int y = -1;
            for(int j = 0; j < map.length; j++){
                for(int k = 0; k < map[j].length; k++){
                    if(map[j][k] == '^' || map[j][k] == 'v' || map[j][k] == '<' || map[j][k] == '>'){
                        x = j;
                        y = k;
                        break;
                    }
                }
                if(x > -1 || y > -1) break;
            }
            for(int j = 0; j < command.length; j++){
                char c = command[j];
                switch(c){
                    case 'U':
                        int case1X = x - 1;
                        if(case1X >= 0 && map[case1X][y] == '.' ){
                            map[x][y] = '.';
                            map[case1X][y] = '^';
                            x = case1X;
                        }
                        else{
                            map[x][y] = '^';
                        }
                        break;
                    case 'D':
                        int case2X = x + 1;
                        if(case2X < H && map[case2X][y] == '.' ){
                            map[x][y] = '.';
                            map[case2X][y] = 'v';
                            x = case2X;
                        }
                        else{
                            map[x][y] = 'v';
                        }
                        break;
                    case 'L':
                        int case3Y = y - 1;
                        if(case3Y >= 0 && map[x][case3Y] == '.' ){
                            map[x][y] = '.';
                            map[x][case3Y] = '<';
                            y = case3Y;
                        }
                        else{
                            map[x][y] = '<';
                        }
                        break;
                    case 'R':
                        int case4Y = y + 1;
                        if(case4Y < W && map[x][case4Y] == '.' ){
                            map[x][y] = '.';
                            map[x][case4Y] = '>';
                            y = case4Y;
                        }
                        else{
                            map[x][y] = '>';
                        }
                        break;
                    case 'S':
                        char dir = map[x][y];
                        if(dir == '^'){
                            for(int k = 1; k < H; k++){
                                int nx = x - k;
                                if(nx > -1 && map[nx][y] == '*'){
                                    map[nx][y] = '.';
                                    break;
                                }
                                else if(nx > -1 && map[nx][y] == '#'){
                                    break;
                                }
                            }
                        }
                        else if(dir == 'v'){
                            for(int k = 1; k < H; k++){
                                int nx = x + k;
                                if(nx < H && map[nx][y] == '*'){
                                    map[nx][y] = '.';
                                    break;
                                }
                                else if(nx < H && map[nx][y] == '#'){
                                    break;
                                }
                            }
                        }
                        else if(dir == '<'){
                            for(int k = 1; k < W; k++){
                                int ny = y - k;
                                if(ny > -1 && map[x][ny] == '*'){
                                    map[x][ny] = '.';
                                    break;
                                }
                                else if(ny > -1 && map[x][ny] == '#'){
                                    break;
                                }
                            }
                        }
                        else if(dir == '>'){
                            for(int k = 1; k < W; k++){
                                int ny = y + k;
                                if(ny < W && map[x][ny] == '*'){
                                    map[x][ny] = '.';
                                    break;
                                }
                                else if(ny < W && map[x][ny] == '#'){
                                    break;
                                }
                            }
                        }
                        break;
                    default: break;
                }
            }
            System.out.print("#" + i + " ");
            for(int j = 0; j < map.length; j++){
                for(int k = 0; k < map[j].length; k++){
                    System.out.print(map[j][k]);
                }
                System.out.println();
            }
        }
    }
}
