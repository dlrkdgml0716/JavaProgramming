import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'3', '6', '9'};
        for(int i = 1; i <= N; i++){
            String num = String.valueOf(i);
            game(cArr, num, sb);
        }
        System.out.print(sb.toString().trim());
    }
    static void game(char[] cArr, String num, StringBuilder sb){
        boolean check = false;
        int count = 0;
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            for(int j = 0; j < cArr.length; j++){
                if(cArr[j] == c){
                    check = true;
                    count++;
                }
            }
        }
        if(check){
            for(int i = 0; i < count; i++){
                sb.append('-');
            }
            sb.append(' ');
        }
        else sb.append(num).append(' ');
    }
}