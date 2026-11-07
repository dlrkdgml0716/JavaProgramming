import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            String tc = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            String[] num = new String[N];
            st = new StringTokenizer(sc.nextLine());
            for(int j = 0; j < N; j++){
                num[j] = st.nextToken();
            }
            strToInt(num);
            Arrays.sort(num);
            intToStr(num);

            System.out.println(tc);
            for(int j = 0; j < num.length; j++){
                System.out.print(num[j] + " ");
            }
            System.out.println();
        }
    }
    static void strToInt(String[] num){
        for(int i = 0; i < num.length; i++){
            if(num[i].equals("ZRO")) num[i] = "0";
            else if(num[i].equals("ONE")) num[i] = "1";
            else if(num[i].equals("TWO")) num[i] = "2";
            else if(num[i].equals("THR")) num[i] = "3";
            else if(num[i].equals("FOR")) num[i] = "4";
            else if(num[i].equals("FIV")) num[i] = "5";
            else if(num[i].equals("SIX")) num[i] = "6";
            else if(num[i].equals("SVN")) num[i] = "7";
            else if(num[i].equals("EGT")) num[i] = "8";
            else if(num[i].equals("NIN")) num[i] = "9";
        }
    }
    static void intToStr(String[] num){
        for(int i = 0; i < num.length; i++){
            if(num[i].equals("0")) num[i] = "ZRO";
            else if(num[i].equals("1")) num[i] = "ONE";
            else if(num[i].equals("2")) num[i] = "TWO";
            else if(num[i].equals("3")) num[i] = "THR";
            else if(num[i].equals("4")) num[i] = "FOR";
            else if(num[i].equals("5")) num[i] = "FIV";
            else if(num[i].equals("6")) num[i] = "SIX";
            else if(num[i].equals("7")) num[i] = "SVN";
            else if(num[i].equals("8")) num[i] = "EGT";
            else if(num[i].equals("9")) num[i] = "NIN";
        }
    }
}