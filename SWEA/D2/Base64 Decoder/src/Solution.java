import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < T; i++){
            StringBuilder sb = new StringBuilder();
            StringBuilder result = new StringBuilder();
            String s = sc.nextLine();
            String decoding = sixBits(s, sb);
            for(int j = 0; j < decoding.length(); j+=8){
                String str = decoding.substring(j, j+8);
                int num = 0;
                for(int k = 0; k < 8; k++){
                    if(str.charAt(k) == '1'){
                        num += (int)Math.pow(2, 7-k);
                    }
                }
                result.append((char)num);
            }
            System.out.println("#" + (i+1) + " " + result.toString());
        }
    }
    static String sixBits(String s, StringBuilder sb){
        int num;
        for(int i = 0; i < s.length(); i++){
            StringBuilder bits = new StringBuilder();
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z') num = c - 'A';
            else if (c >= 'a' && c <= 'z') num = c - 'a' + 26;
            else if (c >= '0' && c <= '9') num = c - '0' + 52;
            else if (c == '+') num = 62;
            else if (c == '/') num = 63;
            else throw new IllegalArgumentException("잘못된 문자: " + c);

            while(num > 0){
                bits.insert(0, num%2);
                num /= 2;
            }
            while (bits.length() < 6) {
                bits.insert(0, '0');
            }
            sb.append(bits.toString());
        }
        return sb.toString();
    }
}