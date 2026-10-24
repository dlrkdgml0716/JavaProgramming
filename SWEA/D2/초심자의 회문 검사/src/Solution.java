import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < T; i++){
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int j = s.length()-1; j >= 0; j--){
                sb.append(s.charAt(j));
            }
            String reverse = sb.toString();
            if(s.equals(reverse)) System.out.println("#" + (i+1) + " " + 1);
            else System.out.println("#" + (i+1) + " " + 0);
        }
    }
}