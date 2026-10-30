import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            int T = sc.nextInt();
            sc.nextLine();
            char[][] map = new char[100][100];
            for(int j = 0; j < 100; j++){
                String s = sc.nextLine();
                for(int k = 0; k < 100; k++){
                    map[j][k] = s.charAt(k);
                }
            }

            int max = 0;
            for(int len = 100; len >= 1; len--){
                for(int row = 0; row < 100; row++){
                    for(int start = 0; start <= 100 - len; start++){
                        boolean rowPossible = true;
                        boolean colPossible = true;

                        for(int k = 0; k < len/2; k++){
                            if(map[row][start+k] != map[row][start + len - k - 1]){
                                rowPossible = false;
                            }
                            if(map[k+start][row] != map[start+len-k-1][row]){
                                colPossible = false;
                            }
                            if(!rowPossible && !colPossible) break;
                        }
                        if(rowPossible || colPossible) {
                            max = len;
                            break;
                        }
                    }
                    if(max > 0) break;
                }
                if(max > 0) break;
            }
            System.out.println("#" + T + " " + max);
        }
    }
}