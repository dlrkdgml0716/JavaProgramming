import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            int pLine = findLine(p);
            int qLine = findLine(q);

            int pX = findX(pLine, p);
            int qX = findX(qLine, q);

            int pY = pLine - pX + 1;
            int qY = qLine - qX + 1;

            System.out.println("#" + i + " " + change(pX+qX, pY+qY));
        }
    }
    static int findLine(int score) {
        int line = 1;
        int sum = 0;
        while(line + sum < score) {
            sum += line;
            line++;
        }

        return line;
    }
    static int findX(int line, int score) {
        int preNum = 0;

        for(int i = 1; i < line; i++) {
            preNum += i;
        }

        return score - preNum;
    }
    static int change(int x, int y) {
        int ny = x + y - 1;
        int sum = 0;

        for(int i = 1; i < ny; i++) {
            sum += i;
        }
        return sum + x;
    }
}