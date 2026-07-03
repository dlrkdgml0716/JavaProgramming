import java.util.*;
public class Main {
    static List<String> li;
    public static void main(String[] args) {
        li = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] visited = new boolean[N+1];
        solved(N, "", 0);
        for(String s : li){
            System.out.println(s);
        }
    }
    public static void solved(int N, String current, int depth){
        if(depth == N){
            if(cal(current)){
                li.add(current);
            }
            return;
        }
        if(depth == 0){
            solved(N, "1", depth + 1);
        }
        else {
            int nextNum = depth + 1;
            solved(N, current + " " + nextNum, depth + 1);
            solved(N, current + "+" + nextNum, depth + 1);
            solved(N, current + "-" + nextNum, depth + 1);
        }
    }
    public static boolean cal(String s) {
        String removedSpace = s.replace(" ", "");
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        String numStr = "";
        for (int i = 0; i < removedSpace.length(); i++) {
            char c = removedSpace.charAt(i);

            if (c == '+' || c == '-') {
                operators.add(c);
                numbers.add(Integer.parseInt(numStr));
                numStr = "";
            } else {
                numStr += c;
            }
        }
        numbers.add(Integer.parseInt(numStr));
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '+') {
                result += numbers.get(i + 1);
            } else if (operators.get(i) == '-') {
                result -= numbers.get(i + 1);
            }
        }
        return result == 0;
    }
}