import java.util.*;
public class Main {
    static int count;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        count = 0;
        binaryCom("", n);
        System.out.print(count);
    }
    public static void binaryCom(String num, int depth){
        if(num.length() == depth){
            if(zeroCheck(num)) count++;
            return;
        }
        binaryCom(num+"1", depth);
        binaryCom(num+"0", depth);
    }
    public static boolean zeroCheck(String s){
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '0' && s.charAt(i+1) == '0') return false;
        }
        return true;
    }
}
