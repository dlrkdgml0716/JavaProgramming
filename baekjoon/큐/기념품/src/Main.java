import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            al.add(i);
        }

        int currentIndex = 0;
        long step = 1;

        while (al.size() > 1) {
            long move = step * step * step;
            currentIndex = (int) ((currentIndex + (move - 1)) % al.size());
            al.remove(currentIndex);
            step++;
        }
        System.out.println(al.get(0));
    }
}