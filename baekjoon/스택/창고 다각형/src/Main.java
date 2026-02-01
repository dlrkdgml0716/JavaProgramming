import java.util.*;
import java.io.*;

public class Main {
    static class Pillar implements Comparable<Pillar> {
        int l, h;
        Pillar(int l, int h) { this.l = l; this.h = h; }
        @Override
        public int compareTo(Pillar o) { return this.l - o.l; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pillar[] pillars = new Pillar[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pillars[i] = new Pillar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 1. 위치 기준 정렬
        Arrays.sort(pillars);

        int totalArea = 0;

        // 2. 왼쪽 스택: 앞에서부터 최고 기둥까지
        Stack<Pillar> leftStack = new Stack<>();
        Pillar current = pillars[0];
        leftStack.push(current);

        for (int i = 1; i < N; i++) {
            if (pillars[i].h > leftStack.peek().h) {
                // 이전 기둥부터 현재 기둥 전까지 면적 계산
                totalArea += (pillars[i].l - leftStack.peek().l) * leftStack.peek().h;
                leftStack.push(pillars[i]);
            }
        }

        // 3. 오른쪽 스택: 뒤에서부터 최고 기둥까지
        Stack<Pillar> rightStack = new Stack<>();
        Pillar last = pillars[N - 1];
        rightStack.push(last);

        for (int i = N - 2; i >= 0; i--) {
            if (pillars[i].h > rightStack.peek().h) {
                // 오른쪽 끝에서부터 거꾸로 오며 면적 계산
                totalArea += (rightStack.peek().l - pillars[i].l) * rightStack.peek().h;
                rightStack.push(pillars[i]);
            }
        }

        // 4. 마지막 남은 최고 기둥들 사이 구간 처리
        // 왼쪽 스택의 Top과 오른쪽 스택의 Top은 가장 높은 기둥(들)임
        totalArea += (rightStack.peek().l - leftStack.peek().l + 1) * leftStack.peek().h;

        System.out.println(totalArea);
    }
}