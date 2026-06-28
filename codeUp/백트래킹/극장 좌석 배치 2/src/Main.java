import java.util.*;
public class Main {
    static int count;
    public static void main(String[] args) {
        count = 0;
        Scanner sc = new Scanner(System.in);
        int seats = sc.nextInt();
        int people = sc.nextInt();
        solved(seats, people, 0, 0);
        System.out.print(count);
    }
    public static void solved(int seats, int people, int currentS, int currentP){
        if(currentP == people){
            count++;
            return;
        }
        for(int i = currentS; i <= seats - ((people - currentP) * 2 - 1) + currentP; i++){
            solved(seats, people, i + 2, currentP + 1);
        }
    }
}