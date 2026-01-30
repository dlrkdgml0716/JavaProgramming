import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chance = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (chance-- > 0) {
            String s = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char cmd = s.charAt(i);

                switch (cmd) {
                    case '<':
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(cmd);
                        break;
                }
            }
            StringBuilder sb = new StringBuilder();

            for (Character c : left) {
                sb.append(c);
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }

            System.out.println(sb.toString());
        }
    }
}
// for-each 구문으로 스택에 있는 값을 빼면 먼저 스택에 들어간 순서대로 나옴