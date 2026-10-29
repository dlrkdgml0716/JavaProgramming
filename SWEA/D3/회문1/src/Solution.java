import java.util.*;

public class Solution {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 10; i++){
            count = 0;
            int n = sc.nextInt();
            sc.nextLine();

            char[][] map = new char[8][8];
            for(int j = 0; j < 8; j++){
                String s = sc.nextLine();
                for(int k = 0; k < 8; k++){
                    map[j][k] = s.charAt(k);
                }
            }

            for(int j = 0; j < 8; j++){
                for(int k = 0; k <= 8 - n; k++){
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    for(int l = 0; l < n; l++){
                        sb1.append(map[j][k+l]);
                        sb2.append(map[k+l][j]);
                    }
                    String s1 = sb1.toString();
                    String s2 = sb2.toString();
                    check(s1, s2);
                }
            }
            System.out.println("#" + i + " " + count);
        }
    }
    static void check(String s1, String s2){
        boolean bol1 = true;
        boolean bol2 = true;
        for(int i = 1; i <= s1.length()/2; i++){
            if(s1.charAt(i-1) != s1.charAt(s1.length()-i)){
                bol1 = false;
                break;
            }
        }
        for(int i = 1; i <= s1.length()/2; i++){
            if(s2.charAt(i-1) != s2.charAt(s1.length()-i)){
                bol2 = false;
                break;
            }
        }
        if(bol1) count++;
        if(bol2) count++;
    }
}