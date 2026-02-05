import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        double[] values = new double[N];
        for (int i = 0; i < N; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                stack.push(values[ch - 'A']);
            }
            else {
                double a = stack.pop();
                double b = stack.pop();

                switch(ch) {
                    case '+': stack.push(b + a); break;
                    case '-': stack.push(b - a); break;
                    case '*': stack.push(b * a); break;
                    case '/': stack.push(b / a); break;
                }
            }
        }
        System.out.printf("%.2f\n", stack.pop());
    }
}