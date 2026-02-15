import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        int id, prefer;
        public Student(int id, int prefer) {
            this.id = id;
            this.prefer = prefer;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Student> queue = new ArrayDeque<>();
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int id = Integer.parseInt(st.nextToken());
                int prefer = Integer.parseInt(st.nextToken());
                queue.add(new Student(id, prefer));
            } else if (type == 2) {
                int menu = Integer.parseInt(st.nextToken());
                if (!queue.isEmpty()) {
                    Student s = queue.poll();
                    if (s.prefer == menu) listA.add(s.id);
                    else listB.add(s.id);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        appendResult(sb, listA);
        appendResult(sb, listB);

        List<Integer> listC = new ArrayList<>();
        while (!queue.isEmpty()) {
            listC.add(queue.poll().id);
        }
        appendResult(sb, listC);

        System.out.print(sb);
    }
    private static void appendResult(StringBuilder sb, List<Integer> list) {
        if (list.isEmpty()) {
            sb.append("None");
        } else {
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i < list.size() - 1) sb.append(" ");
            }
        }
        sb.append("\n");
    }
}