import java.util.*;
public class Main {
    static int count;
    public static void main(String[] args) {
        count = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fillRectangle(0, n);
        System.out.print(count);
    }
    public static void fillRectangle(int n, int depth){
        if(n == depth){
            count++;
            return;
        }
        if(n + 2 <= depth){
            fillRectangle(n+2, depth);
        }
        if(n + 1 <= depth){
            fillRectangle(n+1, depth);
        }
    }
}
