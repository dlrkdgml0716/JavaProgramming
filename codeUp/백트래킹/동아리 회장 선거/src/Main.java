import java.util.*;
public class Main {
    static List<String> li;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        li = new ArrayList<>();
        vote(li, "", n);
        for(String s : li){
            System.out.println(s);
        }
    }
    public static void vote(List<String> li, String s, int people){
        if(s.length() == people){
            li.add(s);
            return;
        }
        vote(li, s+"O", people);
        vote(li, s+"X", people);
    }
}
